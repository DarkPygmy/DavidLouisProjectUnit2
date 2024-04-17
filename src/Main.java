import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Cupcake> cupcakeMenu = setUpCupcakeMenu();
        ArrayList<Drink> drinkMenu = setUpDrinkMenu();
        new Order(cupcakeMenu, drinkMenu);
    }

    private static ArrayList<Cupcake> setUpCupcakeMenu() {
        ArrayList<Cupcake> cupcakeMenu = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        cupcakeMenu.add(createCupcake(input, new Cupcake("A standard, generic cupcake, with vanilla frosting")));
        cupcakeMenu.add(createCupcake(input, new RedVelvet("A red velvety based cupcake, with cream cheese frosting")));
        cupcakeMenu.add(createCupcake(input, new Chocolate("A cupcake of chocolate scrumptiousness, with chocolate frosting")));
        return cupcakeMenu;
    }

    private static Cupcake createCupcake(Scanner input, Cupcake cupcake) {
        System.out.println("We're determining the price for our " + cupcake.getDescription() + ". Here is the description:");
        cupcake.describe();
        System.out.println("How much would you like to charge for the cupcake? (Input a numerical number taken to 2 decimal places)");
        double price = Double.parseDouble(input.nextLine());
        cupcake.setPrice(price);
        return cupcake;

    }

    private static ArrayList<Drink> setUpDrinkMenu() {
        ArrayList<Drink> drinkMenu = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        drinkMenu.add(createDrink(input, new Water("A bottle of water.")));
        drinkMenu.add(createDrink(input, new Soda("A bottle of soda.")));
        drinkMenu.add(createDrink(input, new Milk("A bottle of milk.")));
        return drinkMenu ;
    }

    private static Drink createDrink(Scanner input, Drink drink) {
        System.out.println("We're determining the price for our " + drink.getDescription() + ". Here is the description:");
        drink.describe();
        System.out.println("So how much for this bottle? (Please input a numerical number taken to 2 decimal places)");
        double price = Double.parseDouble(input.nextLine());
        drink.setPrice(price);
        return drink;
      }

}