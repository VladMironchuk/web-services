package by.bsu.vlad.fridge.controllers;


import by.bsu.vlad.fridge.db.MemoryDb;
import by.bsu.vlad.fridge.entities.Fridge;
import by.bsu.vlad.fridge.entities.Product;
import by.bsu.vlad.fridge.enums.Section;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.ArrayList;

@WebService
public class FridgeEndpoint {
    @WebMethod
    public Fridge getFridge() {
        return MemoryDb.getFridge();
    }

    @WebMethod
    public ArrayList<Product> getAllProducts() {
        return MemoryDb.getAllProducts();
    }

    @WebMethod
    public ArrayList<Product> getProductsFromCompartment() {
        return MemoryDb.getProductsBySection(Section.COMPARTMENT);
    }

    @WebMethod
    public ArrayList<Product> getProductsFromFreezer() {
        return MemoryDb.getProductsBySection(Section.FREEZER);
    }

    @WebMethod
    public void cleanCompartment() {
        MemoryDb.cleanSection(Section.COMPARTMENT);
    }

    @WebMethod
    public void cleanFreezer() {
        MemoryDb.cleanSection(Section.FREEZER);
    }

    @WebMethod
    public void addProduct(@WebParam(name = "name") String name, @WebParam(name = "section") String section) {
        if(section.equals("compartment")) {
            MemoryDb.addProduct(name, Section.COMPARTMENT);
        }
        if(section.equals("freezer")) {
            MemoryDb.addProduct(name, Section.FREEZER);
        }
    }

    @WebMethod
    public void deleteProduct(@WebParam(name = "id") String id) {
        MemoryDb.deleteProduct(id);
    }

    @WebMethod
    public void moveProductToCompartment(@WebParam(name = "id") String id) {
        MemoryDb.replaceProduct(id, Section.COMPARTMENT);
    }

    @WebMethod
    public void moveProductToFreezer(@WebParam(name = "id") String id) {
        MemoryDb.replaceProduct(id, Section.FREEZER);
    }
}
