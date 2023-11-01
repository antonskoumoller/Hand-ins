import java.util.Arrays;
import java.util.regex.*;

/**
 * PapTalk
 */
public class PepTalk {

    String result;

    public PepTalk() {

        String line = "Coffee Coffee";
        Pattern splitPattern = Pattern.compile("\s");
        System.out.println(line);

        // Pattern syllabusPattern = Pattern.compile("[\\p{Alpha}&&[^aeiouAEIOU]]*[aeiouAEIOU][\\p{Alpha}&&[^aeiouAEIOU]]*");
        Pattern syllabusPattern = Pattern.compile("\\w*[aeiouAEIOU]\\w*[aeiouAEIOU]");
        Pattern syllabusPattern2 = Pattern.compile("\\w*[aeiouAEIOU]\\w*");
        
        String[] splitLine = splitPattern.split(line);

        StringBuilder peptalk = new StringBuilder();
        int k = 1;
        while (k < 10) {
            Matcher match = syllabusPattern.matcher(line);        
        }       
        
        result = peptalk.toString().trim();
        System.out.println(result);
    
    }

    public static boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) >= 0;
    }

    public static void main(String[] args) {
        
        PepTalk pep = new PepTalk();

    }
}