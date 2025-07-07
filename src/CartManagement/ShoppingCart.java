package CartManagement;

import model.CartItem;
import model.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//Management of Cart: adding, removing.

public class ShoppingCart {

   List<CartItem> items = new ArrayList<>();
    //logic: Increment quantitiy if product already exists, otherwise just add.
    public void add(Product product){
        for(CartItem item: items) {
            if (item.getProduct().getName().equalsIgnoreCase(product.getName())) {
                item.incrementQuantity();
                System.out.println("Quantity increased of " + product.getName());
                return;
            }
        }

            items.add(new CartItem(product));
            System.out.println(product.getName() + "Added to Cart and quantity: 1");


    }

    //logic: Decrement product

    public void decrement(String name){
        for(CartItem item: items){
            if(item.getProduct().getName().equalsIgnoreCase(name)){
                item.decrementQuantity();

                if(item.getQuantity() == 0){
                    remove(name);
                } else {
                    System.out.println("Decremented Successfully");
                }
            }
        }
    }


    //logic: If the product name does not exist, nothing gets removed.
    public void remove(String name){
        for(CartItem item: items){
            if(item.getProduct().getName().equalsIgnoreCase(name)){
                items.remove(item);
                return;
            }else{
                System.out.println("Item does not exist");
            }
        }
    }

    public double getTotal(){
        double total = 0;
        for(CartItem item: items){
            total += item.getTotalPrice();
        }
        return total;
    }

    public void displayCart(){
        if(items.isEmpty()){
            System.out.println("Cart Empty");
            return;
        }
        System.out.println("\n=== Cart Contents ===");
        for(CartItem item: items){
            System.out.println(item);
        }
        System.out.println("Total: $" + getTotal());
    }
}
