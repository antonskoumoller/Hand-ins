import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Shopper {
    
    private Map<String,Integer> availableList; 
    private Map<String,Integer> recipeList; 
    private Map<String,Integer> shoppingList; 
    private String toMap;
    private String line;
    private Scanner sc = new Scanner(System.in);
    private String[] strArr;

    public Shopper() {
        recipeList = new HashMap<>();
        availableList = new HashMap<>();
        shoppingList = new TreeMap<>();

        read();
        constructShoppinglist();
        printShoppingList();
    }

    public void read() {

        while(sc.hasNext()) {
            line = sc.nextLine();
            strArr = line.split(" ");
            toMap = strArr[0];
            switch (toMap) {
                case "RECIPE":
                    toRecipe();
                    break;
            
                case "AVAILABLE":
                    toAvailable();
                    break;
            }
        }
        
    }

    public void toAvailable() {
        while(true) {
            line = sc.nextLine();
            strArr = line.split(" ");
            if (strArr[0].equals("RECIPE")) {
                break;
            }
            availableList.put(strArr[2],Integer.parseInt(strArr[0]));

        }
    }

    public void toRecipe() {
        while(true) {
            line = sc.nextLine();
            strArr = line.split(" ");
            if (strArr[0].equals("RECIPE")) {
                break;
            } else {
                if (recipeList.containsKey(strArr[2])) {
                    int amount = Integer.parseInt(strArr[0]) + recipeList.get(strArr[2]);
                    recipeList.remove(strArr[2]);
                    recipeList.put(strArr[2], amount);
                } else {
                    recipeList.put(strArr[2], Integer.parseInt(strArr[0]));
                }
            }
            
        }
    }

    public void constructShoppinglist() {
        for(String ingredient: recipeList.keySet()) {
            if(availableList.containsKey(ingredient)) {
                if(availableList.get(ingredient) - recipeList.get(ingredient) < 0){
                    int buyAmount = -(availableList.get(ingredient) - recipeList.get(ingredient));
                    shoppingList.put(ingredient, buyAmount);
                }

            } else if (availableList.get(ingredient) - recipeList.get(ingredient) == 0) {
                
            } else {
                shoppingList.put(ingredient, recipeList.get(ingredient));
            }
        }
    }


    public void printShoppingList() {
        System.out.println("Shopping List: ");
        for (String ingredient: shoppingList.keySet()) {
            String key = ingredient;
            int value = shoppingList.get(key);
            System.out.println(value + " g " + key);
        }
    }
}


