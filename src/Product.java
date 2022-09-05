import java.util.*;

public class Product implements Comparable<Product> {

    private int id;
    private String name;
    private int price;

    public Product() {
        id = 0;
        name = null;
        price = 0;
    }

    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int compareTo(Product anotherProduct) {
        return (price - anotherProduct.getPrice());
    }

    @Override
    public String toString() {
        return name + " (ID + " + id + ", " + price + "$)";
    }

    @Override
    public int hashCode() {
        int hashCode = id;
        hashCode = 31 * hashCode + (name == null ? 0 : name.hashCode());
        hashCode = 31 * hashCode + price;
        return hashCode;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Product product = (Product) object;
        if (id != product.getId()) {
            return false;
        }
        if (price != product.getPrice()) {
            return false;
        }
        return name.equals(product.getName());
    }
}

