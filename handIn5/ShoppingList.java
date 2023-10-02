import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;



/**
 * ShoppingList
 */
public class ShoppingList {

    private Map<String,Integer> availableList; 
    private Map<String,Integer> recipeList; 
    private Map<String,Integer> shoppingList; 
    
    public ShoppingList() {
        recipeList = new HashMap<>();
        availableList = new HashMap<>();
        shoppingList = new TreeMap<>();
        // read();
        // constructShoppinglist();
        // printShoppingList();        
        
    }

    public void printShoppingList() {
        constructShoppinglist();
        System.out.println("Shopping List:");
        for (String ingredient: shoppingList.keySet()) {
            String key = ingredient;
            int value = shoppingList.get(key);
            System.out.println(value + " g " + key);
        }
    }

    public void read()  {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        while(sc.hasNextLine()) {
            
            if(line.contains("AVAILABLE")) {
                while(sc.hasNextLine()) {
                    line = sc.nextLine();
                    if(line.contains("RECIPE")) {
                        break;
                    }
                    readToAvailable(line);       
                }

            } else if (line.contains("RECIPE")) {
                while(sc.hasNextLine()) {
                    line = sc.nextLine();
                    if (line.contains("RECIPE")) {
                        break;
                    }
                    readToRecipe(line);
                }
            }
        }
        sc.close();
    } 

    private void readToAvailable(String line) {
        String[] arrStr = line.split(" ");
        int amount;
        String ingredient;
        try {
            amount = Integer.parseInt(arrStr[0]);
        } catch (Exception e) {
            return;
        }
        
        if (arrStr[1].equals("kg")) {
            amount = amount * 1000; 
        }
        ingredient = arrStr[2];
        availableList.put(ingredient, amount);
    }
    
    private void readToRecipe(String line) {
        String[] arrStr = line.split(" ");
        int amount;
        String ingredient;

        try {
            amount = Integer.parseInt(arrStr[0]);
        } catch (Exception e) {
            return;
        }

        if (arrStr[1].equals("kg")) {
            amount = amount * 1000; 
        }
        ingredient = arrStr[2];
        if (recipeList.containsKey(ingredient)) {
            int newAmount = amount + recipeList.get(ingredient);
            recipeList.remove(ingredient);
            recipeList.put(ingredient, newAmount);
        } else {
            recipeList.put(ingredient, amount);

        }
    }


    public void constructShoppinglist() { 
        for(String ingredient: recipeList.keySet()) {
            if(availableList.containsKey(ingredient)) {
                if(availableList.get(ingredient) - recipeList.get(ingredient) < 0){
                    int buyAmount = -(availableList.get(ingredient) - recipeList.get(ingredient));
                    shoppingList.put(ingredient, buyAmount);
                } else if (availableList.get(ingredient) - recipeList.get(ingredient) == 0) {

                }

            }  else {
                shoppingList.put(ingredient, recipeList.get(ingredient));
            }
        }
    }

    // private void printAvailable(){
    //     for (String ingredient: availableList.keySet()) {
    //         System.out.println("In Available: " + recipeList.get(ingredient) + " g " + ingredient);
    //     }
    // }

    // private void printRecipe(){
    //     for (String ingredient: recipeList.keySet()) {
    //         System.out.println("In Recipe: " + recipeList.get(ingredient) + " g " + ingredient);
    //     }
    // }

    //  private File readFile() {
    //      File file = new File("C:/Users/anton/Desktop/IP/Hand-ins/handIn5/input.txt");
    //      return file;
    //  }
}