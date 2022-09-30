package by.bsu.vlad.fridge.entities;

import by.bsu.vlad.fridge.enums.Section;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Fridge extends BaseEntity{
    private ArrayList<Product> products;

    public Fridge(ArrayList<Product> products) {
        this.products = products;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void deleteProduct(String id) {
        Product currentProduct = this.getProductById(id);
        if(currentProduct != null) {
            products.remove(currentProduct);
        }
    }

    public Product getProductById(String id) {
        return products.stream().filter(product -> product.getId().equals(id)).findFirst().orElse(null);
    }

    public void updateProductSection(String id, Section section) {
        Product currentProduct = this.getProductById(id);
        this.deleteProduct(id);
        this.addProduct(currentProduct.updateSection(section));
    }

    public ArrayList<Product> getProductsBySection(Section section) {
        return this.products.stream().filter(product -> product.getSection().equals(section)).collect(Collectors.toCollection(ArrayList::new));
    }

    public void cleanFridgeSection(Section section) {
        ArrayList<Product> productsToDelete =
                Arrays.stream(this.products
                        .stream()
                        .filter(product -> product.getSection().equals(section)).toArray(Product[]::new))
                        .collect(Collectors.toCollection(ArrayList::new));
        this.products.removeAll(productsToDelete);
    }
}
