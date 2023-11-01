import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PepTalk {
    private static String pattern = "([^aeiouAEIOU]*)([aeiouAEIOU])([^aeiouAEIOU]*)";
    private static Pattern regex = Pattern.compile(pattern);
    private static String[] arr;
        
    private static StringBuilder encoded = new StringBuilder();
    StringBuilder part = new StringBuilder();
    String previousSyllable = "";
    private static Matcher matcher;

    public static void createMatcher(String input) {
        matcher = regex.matcher(input);
    }

    public static void translateToPeptalk() {
        if (!matcher.find()) {
            return;
        }
        tranlateSyllable(matcher);
        translateToPeptalk();
    
    }

    public static void toArray(String s) {
        arr = s.split(" ");
    }

    public static void tranlateSyllable(Matcher matcher) {
        StringBuilder syllable = new StringBuilder();
        String start = matcher.group(1);
        
        syllable.append(start);
        syllable.append(matcher.group(2));
        String endingConsonants = matcher.group(3);
        syllable.append(endingConsonants);

        if (endingConsonants.length() > 1) {
            syllable.delete(syllable.length()-endingConsonants.length(),syllable.length() - endingConsonants.length()/2);
        }
        String prevSyllable = syllable.toString();
        encoded.append(prevSyllable);
        
        if (isVowel(prevSyllable.charAt(0))) {
            encoded.append("p" + prevSyllable);
        } else {
            encoded.append("p" + prevSyllable.substring(1,prevSyllable.length()));
        }
        
    }

    public static boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) >= 0;
    }

    public static void main(String[] args) {
        createMatcher("ane");
        translateToPeptalk();
        System.out.println(encoded);
        }
    }

