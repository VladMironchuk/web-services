package by.bsu.vlad.fridge.entities;

import by.bsu.vlad.fridge.enums.Section;

public class Product extends BaseEntity {
    private String name;

    private Section section;

    public Product(String name, Section section) {
        this.name = name;
        this.section = section;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Product updateSection(Section section) {
        this.setSection(section);
        return this;
    }
}