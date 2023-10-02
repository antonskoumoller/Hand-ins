import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ShoppingList shop = new ShoppingList();
        shop.read();
        shop.constructShoppinglist();
        shop.printShoppingList();
        

    }
}

