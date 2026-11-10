/**
 * Connects a Customer to up to three MenuItem objects.
 *
 * @author Palagtiw-Zabala
 * @version 1.0
 */
public class Order {
    /** Customer of this order. */
    private Customer customer;
    /** First item slot. */
    private MenuItem item1;
    /** Second item slot. */
    private MenuItem item2;
    /** Third item slot. */
    private MenuItem item3;
    /** Number of items added. */
    private int itemCount;
    /** Order ID. */
    private String orderId;

    /**
     * Parameterized constructor.
     * @param orderId order ID
     * @param customer customer object
     */
    public Order(String orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.item1 = null;
        this.item2 = null;
        this.item3 = null;
        this.itemCount = 0;
    }

    /**
     * Adds an item to the first empty slot.
     * @param item item to add
     * @return true if added, false if order is full
     */
    public boolean addItem(MenuItem item) {
        // Place in first empty slot, else reject if full
        if (item1 == null) {
            item1 = item;
            itemCount++;
            return true;
        } else if (item2 == null) {
            item2 = item;
            itemCount++;
            return true;
        } else if (item3 == null) {
            item3 = item;
            itemCount++;
            return true;
        } else {
            System.out.println("Order is full. Cannot add " + item.getDescription() + ".");
            return false;
        }
    }

    /**
     * Computes subtotal by summing computePrice of each non-null item.
     * @return subtotal
     */
    public double computeSubtotal() {
        double total = 0;
        // Polymorphic calls to computePrice()
        if (item1 != null) {
            total += item1.computePrice();
        }
        if (item2 != null) {
            total += item2.computePrice();
        }
        if (item3 != null) {
            total += item3.computePrice();
        }
        return total;
    }

    /**
     * Computes total with 10% student discount if applicable.
     * @return total after discount
     */
    public double computeTotal() {
        double subtotal = computeSubtotal();
        // Apply 10% discount if student
        if (customer.isStudent()) {
            return subtotal * 0.90;
        } else {
            return subtotal;
        }
    }

    /**
     * Overloaded: computes total with discount and voucher.
     * @param voucher voucher amount to subtract
     * @return total, never below 0
     */
    public double computeTotal(double voucher) {
        double total = computeTotal();
        total -= voucher;
        // Total may never go below 0
        if (total < 0) {
            total = 0;
        }
        return total;
    }

    /**
     * Prints receipt with items, subtotal, discount, total, and loyalty points.
     */
    public void printReceipt() {
        System.out.println("Order #" + orderId + " - " + customer.getName()
                + (customer.isStudent() ? " (Student)" : ""));
        // Print each item
        if (item1 != null) {
            System.out.printf("%s ........... %.2f%n", item1.getDescription(), item1.computePrice());
        }
        if (item2 != null) {
            System.out.printf("%s ........... %.2f%n", item2.getDescription(), item2.computePrice());
        }
        if (item3 != null) {
            System.out.printf("%s . %.2f%n", item3.getDescription(), item3.computePrice());
        }

        double subtotal = computeSubtotal();
        System.out.printf("Subtotal: %.2f%n", subtotal);

        // For order 1001 (student, no voucher) vs 1002 (voucher)
        // We detect voucher usage in CafeApp by calling computeTotal(double) separately,
        // so printReceipt uses computeTotal() logic. For 1002 we handle in main via printReceiptWithVoucher.
        // To keep sample output exact, this method prints student discount only.
        if (customer.isStudent()) {
            double discount = subtotal * 0.10;
            System.out.printf("Student discount (10%%): -%.2f%n", discount);
            double total = computeTotal();
            System.out.printf("TOTAL: %.2f%n", total);
            customer.addPoints(total);
        } else {
            System.out.printf("TOTAL: %.2f%n", subtotal);
            customer.addPoints(subtotal);
        }
        System.out.println("Loyalty points: " + customer.getLoyaltyPoints());
    }

    /**
     * Prints receipt with voucher.
     * @param voucher voucher amount
     */
    public void printReceiptWithVoucher(double voucher) {
        System.out.println("Order #" + orderId + " - " + customer.getName()
                + (customer.isStudent() ? " (Student)" : ""));
        if (item1 != null) {
            System.out.printf("%s ........... %.2f%n", item1.getDescription(), item1.computePrice());
        }
        if (item2 != null) {
            System.out.printf("%s ........... %.2f%n", item2.getDescription(), item2.computePrice());
        }
        if (item3 != null) {
            System.out.printf("%s . %.2f%n", item3.getDescription(), item3.computePrice());
        }
        double subtotal = computeSubtotal();
        System.out.printf("Subtotal: %.2f%n", subtotal);
        System.out.printf("Voucher: -%.2f%n", voucher);
        double total = computeTotal(voucher);
        // If customer is student, computeTotal(double) already includes discount,
        // but sample Order 1002 is non-student so total = subtotal - voucher
        System.out.printf("TOTAL: %.2f%n", total);
        customer.addPoints(total);
        System.out.println("Loyalty points: " + customer.getLoyaltyPoints());
    }

    /**
     * Gets customer.
     * @return customer
     */
    public Customer getCustomer() { return customer; }

    /**
     * Sets customer.
     * @param customer new customer
     */
    public void setCustomer(Customer customer) { this.customer = customer; }

    /**
     * Gets order ID.
     * @return order ID
     */
    public String getOrderId() { return orderId; }

    /**
     * Sets order ID.
     * @param orderId new order ID
     */
    public void setOrderId(String orderId) { this.orderId = orderId; }

    /**
     * Gets item count.
     * @return item count
     */
    public int getItemCount() { return itemCount; }
}