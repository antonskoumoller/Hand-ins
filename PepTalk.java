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

        Pattern syllabusPattern = Pattern.compile("[\\p{Alpha}&&[^aeiouAEIOU]]*[aeiouAEIOU][\\p{Alpha}&&[^aeiouAEIOU]]*");
        String[] splitLine = splitPattern.split(line);

        StringBuilder peptalk = new StringBuilder();

        for (String word : splitLine) {
            Matcher match = syllabusPattern.matcher(word);
            StringBuilder pepWord = new StringBuilder();

            while(match.find()) {
                String syllable = match.group();
                pepWord.append("p");

                syllable = syllable.replaceAll("[\\p{Alpha}&&[^aeiouAEIOU]]", "p");

                for (int i = 0; i < syllable.length(); i++) {
                    pepWord.append(syllable.charAt(i));
                    if(i<syllable.length() - 1 && isVowel(syllable.charAt(i))) {
                        pepWord.append("p");
                    }
                }
            }

            peptalk.append(pepWord.toString());
            peptalk.append(" ");            
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