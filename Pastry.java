/**
 * Represents a baked item that can be warmed for an extra fee.
 *
 * @author Palagtiw-Zabala
 * @version 1.0
 */
public class Pastry extends MenuItem {
    /** True if warmed. */
    private boolean warmed;

    /**
     * Default constructor.
     */
    public Pastry() {
        super();
        this.warmed = false;
    }

    /**
     * Parameterized constructor.
     * @param name name of pastry
     * @param basePrice base price
     * @param itemCode item code
     * @param warmed true if warmed
     */
    public Pastry(String name, double basePrice, String itemCode, boolean warmed) {
        super(name, basePrice, itemCode);
        this.warmed = warmed;
    }

    /**
     * Computes price, basePrice plus 10 if warmed.
     * @return price in pesos
     */
    @Override
    public double computePrice() {
        double price = basePrice;
        // Add warm fee using a single if statement
        if (warmed) {
            price += 10;
        }
        return price;
    }

    /**
     * Returns description with Warmed tag when applicable.
     * @return description
     */
    @Override
    public String getDescription() {
        if (warmed) {
            return super.getDescription() + " (Warmed)";
        } else {
            return super.getDescription();
        }
    }

    /**
     * Checks if warmed.
     * @return true if warmed
     */
    public boolean isWarmed() { return warmed; }

    /**
     * Sets warmed status.
     * @param warmed new status
     */
    public void setWarmed(boolean warmed) { this.warmed = warmed; }
}