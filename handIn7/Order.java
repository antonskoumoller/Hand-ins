import java.util.ArrayList;
import java.util.List;

public class Order {
    protected List<Food> ordered;


    public Order() {
        ordered = new ArrayList<>();
    }

    public void addFood(Food food) {
        ordered.add(food);
    }

    // public boolean withdraw(int amount) {
    //     return 
    // }

    public int total() {
        int total = 0; 
        for (Food food : ordered) {
            total += food.getPrice();
        }
        return total;
    }

    public boolean payWith(CreditCard card) {
        boolean success = card.withdraw(total());
        if (!success) {
            System.out.println("ERROR: Payment failed");
            return success;
        }
        return success;
    }

    public void display() {
        for (Food food : ordered) {
            food.display();
            System.out.println();
        }
        System.out.println(total() + " kr TOTAL");
    } 
}
