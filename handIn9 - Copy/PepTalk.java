import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PepTalk {
    String pattern = "([^aeiouAEIOU]*)([aeiouAEIOU])([^aeiouAEIOU]*)";
    Pattern regex = Pattern.compile(pattern);

    String pattern2 = "([^aeiouAEIOU]*)([aeiouAEIOU])";
    Pattern regex2 = Pattern.compile(pattern2);

    
    String previousConsonants = "";
    String result = "";
    List<String> syllableArray;

    public PepTalk(String s) {
        String[] arr = splitToWords(s);
        for (String string : arr) {
            List<String> syllables = splitToSyllables(string);
            List<String> encodedSyls = addEncoding(syllables);
            result += syllablesToString(encodedSyls);
            result += " ";
            
        }
        System.out.println(syllableArray.toString());
        System.out.println(result);

    }

    public String[] splitToWords(String s) {
        String[] split = s.split(" ");
        return split;
    }

    public List<String> splitToSyllables(String s) {
            Matcher matcher = regex.matcher(s);
            syllableArray = new ArrayList<>();            
            while(matcher.find()) {
                syllableArray.add(buildSyllable(s, matcher));
            }
        return syllableArray;
    }

    public String buildSyllable(String s,Matcher matcher) {
        StringBuilder syllable = new StringBuilder();
        String start = matcher.group(1);
        syllable.append(previousConsonants);
        syllable.append(start);
        syllable.append(matcher.group(2));
        previousConsonants = matcher.group(3);

        switch (previousConsonants.length()) {
            case 2:
                syllable.append(previousConsonants);
                syllable.delete(syllable.length()-1,syllable.length());
                previousConsonants = previousConsonants.substring(previousConsonants.length()/2, previousConsonants.length());
                break;
        
            case 3:
                syllable.append(previousConsonants);
                syllable.delete(syllable.length()-2,syllable.length());
                previousConsonants = previousConsonants.substring(previousConsonants.length()/2, previousConsonants.length());            

                break;
            default:
                break;
        }
        return syllable.toString();
        // if (previousConsonants.length() != 1
        //     && previousConsonants.length()!= 0) {
        //         syllable.append(previousConsonants);
        //         syllable.delete(syllable.length()-(previousConsonants.length()),syllable.length() - (previousConsonants.length()/2));
        //         previousConsonants = previousConsonants.substring(previousConsonants.length()/2, previousConsonants.length());
                 
        // }
    }

    public List<String> addEncoding(List<String> syl) {
        List<String> codedSyllables = new ArrayList<>();
        for (String string : syl) {
            String old = string;
            String toAdd = replaceLeadingConsonants(old);
            codedSyllables.add(old);
            codedSyllables.add(toAdd);
        }

        return codedSyllables;

    }

    public String syllablesToString(List<String> s) {
        StringBuilder appendedSyllables = new StringBuilder();
        for (String string : s) {
            appendedSyllables.append(string);
        }

        return appendedSyllables.toString();
    }

    public String replaceLeadingConsonants(String syllable) {
        StringBuilder string = new StringBuilder();
        string.append("p");
        boolean vowelFound = false;
        for(int i = 0; i < syllable.length();i++) {
            if(isVowel(syllable.charAt(i)) || vowelFound) {
                vowelFound = true;
                string.append(syllable.charAt(i));
            }
        }

        return string.toString();
    }

    public boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) >= 0;
    }

    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // StringBuilder string = new StringBuilder();
        // while(sc.hasNextLine()) {
        //     string.append(sc.nextLine());
        // }

        // PepTalk shit = new PepTalk(string.toString());
        PepTalk shit = new PepTalk("I like turtles");

    }

}
