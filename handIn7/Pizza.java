import java.util.ArrayList;
import java.util.List;

public class Pizza extends Food {
    
    protected List<String> toppings; 

    public Pizza() {
        super("Pizza",45);
        toppings = new ArrayList<>();

    }

    public void addTopping(String top) {
        toppings.add(top);
        price += 10;
    }

    public void setName(String name) {
        super.name = name;
    }

    // @Override
    // public void display() {
    //     super.display();
    //     System.out.print(" {");
    //     String output = ""; 
    //     for (String top : toppings) { 
    //         output = output + " " + top + ",";
    //     }

    //     output = output.substring(0,output.length()-1);
    //     System.out.println(output + " }");
        
    // }

    @Override
    public void display() {
        super.display();
        if (toppings.isEmpty()) { System.out.print(" { }"); return; }
        System.out.print(" { ");
        String separator = "";
        for (String top : toppings) { 
            System.out.print(separator);
            System.out.print(top);
            separator = ", ";
        } 
        System.out.print(" }");
        
    }

}


