/**
 * Main class that drives the Campus Cafe Ordering System.
 *
 * @author Palagtiw-Zabala
 * @version 1.0
 */
public class CafeApp {
    /**
     * Main method.
     * @param args command line arguments
     */
    public static void main(String[] args) {
        // Create at least two Customer objects using different constructors
        Customer ana = new Customer("Ana Reyes", true);
        Customer ben = new Customer("Ben Cruz");

        // Create at least one Beverage, one Pastry, one Meal using both default and parameterized constructors
        // Order 1001 items - parameterized
        Beverage icedLatte = new Beverage("Iced Latte", 95, "B-01", "L");
        Pastry ensaymada = new Pastry("Ensaymada", 45, "P-01", true);
        Meal chickenAdobo = new Meal("Chicken Adobo", 110, "M-01", true, 1);
        Pastry cookie = new Pastry("Cookie", 30, "P-02", false);

        // Order 1002 items - Hot Chocolate uses default constructor + setters
        Beverage hotChocolate = new Beverage();
        hotChocolate.setName("Hot Chocolate");
        hotChocolate.setItemCode("B-02");
        hotChocolate.setBasePrice(-5); // Demonstrate setter rejecting invalid data
        hotChocolate.setBasePrice(80);
        hotChocolate.setSize("M");

        Meal beefTapa = new Meal("Beef Tapa", 130, "M-02", false, 0);

        // Create two Order objects
        Order order1 = new Order("1001", ana);
        order1.addItem(icedLatte);
        order1.addItem(ensaymada);
        order1.addItem(chickenAdobo);
        order1.addItem(cookie); // Try to add a fourth item to show limit check
        order1.printReceipt();

        System.out.println();
        Order order2 = new Order("1002", ben);
        order2.addItem(hotChocolate);
        order2.addItem(beefTapa);
        order2.printReceiptWithVoucher(20);
    }
}