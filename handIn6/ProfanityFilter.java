import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
/**
 * ProfanityFilter
 */
public class ProfanityFilter {
    private Scanner sc;
    private String[] characters = {"*","&","#","$","%"};
    private String profanities = "";
    private String[] profArr;
    private ArrayList<String> output = new ArrayList<>();
    private String[] symbols = {"!","?",".",","};


    //  private File readFile() {
    //        File file = new File("C:/Users/anton/Desktop/IP/Hand-ins/Hand-ins/handIn6/input2.txt");
    //        return file;
    //  }
    
    public ProfanityFilter()    {
        sc = new Scanner(System.in);
        readProfanities();
       
        read();  
        stringify();      
        

    }

    public static void main(String[] args)  {
        ProfanityFilter proffilter = new ProfanityFilter();
    }

    private void readProfanities() {
        profanities = sc.nextLine();
        if (profanities.isEmpty()) {
            profanities = "";
            return;   
        }
        profanities = profanities.toLowerCase();
        profArr = profanities.split(" ");
    }

    private void read() {
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.isEmpty()) {
                output.add("");
            } else {
                readLine( new ArrayList<String>(Arrays.asList((line.split(" ")))));
            }
        }
    }


    private void readLine(List<String> a) {
        if (profanities.isEmpty()) {
            toOutput(a);
        } else {
            // TODO: Fix this empty line and new line character insertion shit
            for (int i = 0; i < a.size(); i++) {
                String word = a.get(i);
                if (isProfanity(word.toLowerCase())) {
                    if (containsSymbol(word)) {
                        String symbol = word.substring(word.length()-1, word.length());
                        word = word.substring(0,word.length()-1);
                        a.set(i, "" + replaceProfanity(word) + symbol);
                    } else {
                        a.set(i,replaceProfanity(word));
;
                    }
                }
            }
            toOutput(a);
        }

    }

    private boolean containsSymbol(String a) {
        for (int i = 0; i < symbols.length; i++) {

            if (a.contains(symbols[i])) {
                return true;
            }
        }
        return false;
    }

    private boolean isProfanity(String a) {
        for (int i = 0; i < profArr.length; i++) {
            if (containsSymbol(a)) {
                a = a.substring(0, a.length() - 1);
            }
                if (a.equals(profArr[i])) {
                return true;
            }
        }
        return false;
    }

    private String replaceProfanity(String profanity) {
        String censored = "";
        for (int i = 0; i < profanity.length();i++) {
            censored += characters[i%5];
        }
        return censored;
    }

    private void toOutput(List a) {
        String outputLine = String.join(" ",a);
        output.add(outputLine);
    }

    public void stringify() {
        for (int i = 0; i < output.size(); i++)
        System.out.println(output.get(i));
    }

}