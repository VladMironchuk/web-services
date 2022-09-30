package by.bsu.vlad.fridge.db;


import by.bsu.vlad.fridge.entities.Fridge;
import by.bsu.vlad.fridge.entities.Product;
import by.bsu.vlad.fridge.enums.Section;

import java.util.ArrayList;
import java.util.Arrays;

public class MemoryDb {
    private static final Fridge fridge = new Fridge(new ArrayList<>(Arrays.asList(
            new Product("cheese", Section.COMPARTMENT),
            new Product("beer", Section.COMPARTMENT),
            new Product("pelmeni", Section.FREEZER),
            new Product("meat", Section.FREEZER))
    ));

    static public Fridge getFridge() {
        return fridge;
    }

    static public Product getProductById(String id) {
        return fridge.getProductById(id);
    }

    static public void addProduct(String name, Section section) {
        fridge.addProduct(new Product(name, section));
    }

    static public void deleteProduct(String id) {
        fridge.deleteProduct(id);
    }

    static public void replaceProduct(String id, Section section) {
        fridge.updateProductSection(id, section);
    }

    static public ArrayList<Product> getProductsBySection(Section section) {
        return fridge.getProductsBySection(section);
    }

    static public ArrayList<Product> getAllProducts() {
        return fridge.getProducts();
    }

    static public void cleanSection(Section section) {
        fridge.cleanFridgeSection(section);
    }
}
