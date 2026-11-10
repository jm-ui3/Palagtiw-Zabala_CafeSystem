/**
 * Represents a rice meal that can be upsized.
 *
 * @author Palagtiw-Zabala
 * @version 1.0
 */
public class Meal extends MenuItem {
    /** True if upsized. */
    private boolean upsized;
    /** Number of extra sides. */
    private int extraSides;

    /**
     * Default constructor.
     */
    public Meal() {
        super();
        this.upsized = false;
        this.extraSides = 0;
    }

    /**
     * Parameterized constructor.
     * @param name name of meal
     * @param basePrice base price
     * @param itemCode item code
     * @param upsized true if upsized
     * @param extraSides number of extra sides
     */
    public Meal(String name, double basePrice, String itemCode, boolean upsized, int extraSides) {
        super(name, basePrice, itemCode);
        this.upsized = upsized;
        setExtraSides(extraSides);
    }

    /**
     * Computes price: basePrice + 20 if upsized + 12 per extra side.
     * @return price in pesos
     */
    @Override
    public double computePrice() {
        double price = basePrice;
        // Add upsize fee
        if (upsized) {
            price += 20;
        }
        price += 12 * extraSides;
        return price;
    }

    /**
     * Returns description with upsize status and extra sides.
     * @return description
     */
    @Override
    public String getDescription() {
        String status;
        // Show Upsized or Regular
        if (upsized) {
            status = "Upsized";
        } else {
            status = "Regular";
        }
        return super.getDescription() + " " + status + ", " + extraSides + " side";
    }

    /**
     * Checks if upsized.
     * @return true if upsized
     */
    public boolean isUpsized() { return upsized; }

    /**
     * Sets upsized status.
     * @param upsized new status
     */
    public void setUpsized(boolean upsized) { this.upsized = upsized; }

    /**
     * Gets extra sides.
     * @return extra sides
     */
    public int getExtraSides() { return extraSides; }

    /**
     * Sets extra sides. Rejects negative values.
     * @param extraSides new number of sides
     */
    public void setExtraSides(int extraSides) {
        // Reject negative extra sides
        if (extraSides < 0) {
            System.out.println("Error: extra sides cannot be negative.");
        } else {
            this.extraSides = extraSides;
        }
    }
}