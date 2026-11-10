/**
 * Parent of all menu items. It cannot be instantiated directly.
 *
 * @author Palagtiw-Zabala
 * @version 1.0
 */
public abstract class MenuItem {
    /** Name of the item. */
    protected String name;
    /** Base price before size / extra fees. */
    protected double basePrice;
    /** Unique code of the item. */
    private String itemCode;

    /**
     * Default constructor.
     */
    public MenuItem() {
        this.name = "Unnamed Item";
        this.basePrice = 0.0;
        this.itemCode = "N/A";
    }

    /**
     * Parameterized constructor.
     * @param name name of the item
     * @param basePrice base price of the item
     * @param itemCode code of the item
     */
    public MenuItem(String name, double basePrice, String itemCode) {
        this.name = name;
        setBasePrice(basePrice);
        this.itemCode = itemCode;
    }

    /**
     * Computes the final price of the item.
     * @return the price of this item in pesos
     */
    public abstract double computePrice();

    /**
     * Returns the description of the item.
     * @return name and item code
     */
    public String getDescription() {
        return name + " [" + itemCode + "]";
    }

    /**
     * Gets the name.
     * @return name
     */
    public String getName() { return name; }

    /**
     * Sets the name.
     * @param name new name
     */
    public void setName(String name) { this.name = name; }

    /**
     * Gets the base price.
     * @return base price
     */
    public double getBasePrice() { return basePrice; }

    /**
     * Sets the base price. Rejects negative values.
     * @param basePrice new base price
     */
    public void setBasePrice(double basePrice) {
        // Reject negative price using if-else
        if (basePrice < 0) {
            System.out.println("Error: base price cannot be negative.");
        } else {
            this.basePrice = basePrice;
        }
    }

    /**
     * Gets the item code.
     * @return item code
     */
    public String getItemCode() { return itemCode; }

    /**
     * Sets the item code.
     * @param itemCode new item code
     */
    public void setItemCode(String itemCode) { this.itemCode = itemCode; }
}