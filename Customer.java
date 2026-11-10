/**
 * Represents the person placing the order.
 *
 * @author Palagtiw-Zabala
 * @version 1.0
 */
public class Customer {
    /** Customer name. */
    private String name;
    /** True if student. */
    private boolean student;
    /** Loyalty points earned. */
    private int loyaltyPoints;

    /**
     * Default constructor.
     */
    public Customer() {
        this.name = "Guest";
        this.student = false;
        this.loyaltyPoints = 0;
    }

    /**
     * Constructor with name.
     * @param name customer name
     */
    public Customer(String name) {
        this.name = name;
        this.student = false;
        this.loyaltyPoints = 0;
    }

    /**
     * Constructor with name and student status.
     * @param name customer name
     * @param student true if student
     */
    public Customer(String name, boolean student) {
        this.name = name;
        this.student = student;
        this.loyaltyPoints = 0;
    }

    /**
     * Adds points directly.
     * @param points points to add
     */
    public void addPoints(int points) {
        // Only add positive points
        if (points > 0) {
            loyaltyPoints += points;
        }
    }

    /**
     * Overloaded: adds 1 point for every 50 pesos spent.
     * @param amountSpent total amount spent
     */
    public void addPoints(double amountSpent) {
        int points = (int) (amountSpent / 50);
        loyaltyPoints += points;
    }

    /**
     * Gets name.
     * @return name
     */
    public String getName() { return name; }

    /**
     * Sets name.
     * @param name new name
     */
    public void setName(String name) { this.name = name; }

    /**
     * Checks if student.
     * @return true if student
     */
    public boolean isStudent() { return student; }

    /**
     * Sets student status.
     * @param student new status
     */
    public void setStudent(boolean student) { this.student = student; }

    /**
     * Gets loyalty points.
     * @return loyalty points
     */
    public int getLoyaltyPoints() { return loyaltyPoints; }

    /**
     * Sets loyalty points. Never makes it negative.
     * @param loyaltyPoints new points
     */
    public void setLoyaltyPoints(int loyaltyPoints) {
        // Prevent negative loyalty points
        if (loyaltyPoints < 0) {
            System.out.println("Error: loyalty points cannot be negative.");
        } else {
            this.loyaltyPoints = loyaltyPoints;
        }
    }
}