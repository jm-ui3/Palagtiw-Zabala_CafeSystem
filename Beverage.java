/**
 * Represents a drink sold at the campus cafe.
 * The price depends on the selected size.
 *
 * @author Palagtiw-Zabala
 * @version 1.0
 */
public class Beverage extends MenuItem {
    /** Size: S, M, or L. */
    private String size;    /**
     * Default constructor.
     */
    public Beverage() {
        super();
        this.size = "S";
    }

    /**
     * Parameterized constructor.
     * @param name name of the beverage
     * @param basePrice base price
     * @param itemCode item code
     * @param size size S, M, or L
     */
    public Beverage(String name, double basePrice, String itemCode, String size) {
        super(name, basePrice, itemCode);
        setSize(size);
    }

    /**
     * Computes the final price based on size.
     * @return the price of this beverage in pesos
     */
    @Override
    public double computePrice() {
        // Large adds 25, Medium adds 15, Small uses the base price
        if (size.equals("L")) {
            return basePrice + 25;
        } else if (size.equals("M")) {
            return basePrice + 15;
        } else {
            return basePrice;
        }
    }

    /**
     * Returns description with size.
     * @return description
     */
    @Override
    public String getDescription() {
        return super.getDescription() + " Size: " + size;
    }

    /**
     * Gets the size.
     * @return size
     */
    public String getSize() { return size; }

    /**
     * Sets the size. Accepts only S, M, or L.
     * @param size new size
     */
    public void setSize(String size) {
        // Accept only S, M, L otherwise keep old value
        if (size.equals("S") || size.equals("M") || size.equals("L")) {
            this.size = size;
        } else {
            System.out.println("Error: size must be S, M, or L.");
        }
    }
}