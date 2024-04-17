import java.util.ArrayList;
import java.util.Scanner;



abstract class MenuComponent {
    protected String description;
    protected double price;

    public MenuComponent(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public void describe() {
        System.out.println(description);
    }
}

class Cupcake extends MenuComponent {
    public Cupcake(String description) {
        super(description);
    }
}

class RedVelvet extends Cupcake {
    public RedVelvet(String description) {
        super(description);
    }
}

class Chocolate extends Cupcake {
    public Chocolate(String description) {
        super(description);
    }
}

class Drink extends MenuComponent {
    public Drink(String description) {
        super(description);
    }
}

class Water extends Drink {
    public Water(String description) {
        super(description);
    }
}

class Soda extends Drink {
    public Soda(String description) {
        super(description);
    }
}

class Milk extends Drink {
    public Milk(String description) {
        super(description);
    }
}

// Order class
public class Order {
    public Order(ArrayList<Cupcake> cupcakeMenu, ArrayList<Drink> drinkMenu) {
        System.out.println("Hello customer. Would you like to place an order? (Y or N)");
        Scanner input = new Scanner(System.in);
        String placeOrder = input.nextLine();
        ArrayList<Object> order = new ArrayList<>();

        if (placeOrder.equalsIgnoreCase("Y")) {
            order.add(LocalDate.now());
            order.add(LocalTime.now());
            System.out.println("Here is the menu\nCUPCAKES:");
            displayMenuItems(cupcakeMenu, drinkMenu, input, order);
        } else {
            System.out.println("Have a nice day then");
        }
    }

    private void displayMenuItems(ArrayList<Cupcake> cupcakeMenu, ArrayList<Drink> drinkMenu, Scanner input, ArrayList<Object> order) {
        displayMenuSection("CUPCAKES:", cupcakeMenu);
        displayMenuSection("DRINKS:", drinkMenu);
        processOrder(input, cupcakeMenu, drinkMenu, order);
    }

    private void displayMenuSection(String header, ArrayList<? extends MenuComponent> items) {
        System.out.println(header);
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + "." + items.get(i).getDescription() + " Price: $" + items.get(i).getPrice());
        }
    }

    private void processOrder(Scanner input, ArrayList<Cupcake> cupcakeMenu, ArrayList<Drink> drinkMenu, ArrayList<Object> order) {
        boolean ordering = true;
        while (ordering) {
            System.out.println("What would you like to order? Please use the number associated with each item to order");
            int orderChoice = input.nextInt();
            input.nextLine();
            addItemToOrder(orderChoice, cupcakeMenu, drinkMenu, order);
            System.out.println("Would you like to continue ordering? (Y/N)");
            if (!input.nextLine().equalsIgnoreCase("Y")) {
                ordering = false;
            }
        }
        printOrderDetails(order);
    }

    private void addItemToOrder(int orderChoice, ArrayList<Cupcake> cupcakeMenu, ArrayList<Drink> drinkMenu, ArrayList<Object> order) {
        if (orderChoice >= 1 && orderChoice <= cupcakeMenu.size() + drinkMenu.size()) {
            if (orderChoice <= cupcakeMenu.size()) {
                order.add(cupcakeMenu.get(orderChoice - 1));
            } else {
                order.add(drinkMenu.get(orderChoice - cupcakeMenu.size() - 1));
            }
            System.out.println("Item added to order");
        } else {
            System.out.println("Sorry, we don't seem to have that on the menu");
        }
    }

    private void printOrderDetails(ArrayList<Object> order) {
        System.out.println(order.get(0));
        System.out.println(order.get(1));
        double subTotal = 0;
        for (int i = 2; i < order.size(); i++) {
            MenuComponent item = (MenuComponent) order.get(i);
            System.out.println(item.getDescription());
            System.out.println(item.getPrice());
            subTotal += item.getPrice();
        }
        System.out.println("$" + subTotal);
    }
}
