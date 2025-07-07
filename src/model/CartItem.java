package model;


//Imagine this class as a cart it self. Cart have products. Cart takes care of
//total price, quantity of products. / Structured for one product only.
public class CartItem {
    private Product product;
    private int quantity;

    public CartItem(Product product) {
        this.product = product;
        this.quantity = 1;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void incrementQuantity(){
        this.quantity += 1;
    }

    public void decrementQuantity(){
        this.quantity -= 1;
    }

    public double getTotalPrice(){
        return product.getPrice() * quantity;
    }
    @Override
    public String toString() {
        return String.format("%s - Quantity: %d - Unit Price: $%.2f - Total: $%.2f",
                product.getName(), quantity, product.getPrice(), getTotalPrice());
    }
}
