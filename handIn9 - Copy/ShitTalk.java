import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShitTalk {
    String pattern = "([^aeiouAEIOU]*)([aeiouAEIOU])([^aeiouAEIOU]*)";
    Pattern regex = Pattern.compile(pattern);

    String pattern2 = "([^aeiouAEIOU]*)([aeiouAEIOU])";
    Pattern regex2 = Pattern.compile(pattern2);

    
    String previousConsonants = "";
    String result = "";

    public ShitTalk(String s) {
        String[] arr = splitToWords(s);
        for (String string : arr) {
            List<String> syllables = splitToSyllables(string);
            List<String> encodedSyls = addEncoding(syllables);
            result = syllablesToString(encodedSyls);
            
        }
        System.out.println(result);

    }

    public String[] splitToWords(String s) {
        String[] split = s.split(" ");
        return split;
    }

    public List<String> splitToSyllables(String s) {
            Matcher matcher = regex.matcher(s);
            List<String> syllableArray = new ArrayList<>();            
            while(matcher.find()) {
                syllableArray.add(buildSyllable(s, matcher));
            }
        return syllableArray;
    }

    public String buildSyllable(String s,Matcher matcher) {
        StringBuilder syllable = new StringBuilder();
        String start = matcher.group(1);
        syllable.append(start);
        syllable.append(matcher.group(2));
        String previousConsonants = matcher.group(3);
        if (previousConsonants.length() != 1
            && previousConsonants.length()!= 0) {
                syllable.append(previousConsonants);
                syllable.delete(syllable.length()-previousConsonants.length(),syllable.length() - previousConsonants.length()/2);
                previousConsonants = previousConsonants.substring(previousConsonants.length()/2, previousConsonants.length());
                 
        }
        return syllable.toString();
    }

    public List<String> addEncoding(List<String> syl) {
        List<String> codedSyllables = new ArrayList<>();
        for (String string : syl) {
            String old = string;
            Matcher m = regex2.matcher(old);
            // What the assssssssssssssss
            String leadingConsonants = m.group(1);
            String toAdd = string.substring(leadingConsonants.length());
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

    public static void main(String[] args) {
        ShitTalk shit = new ShitTalk("aa");
}

}
