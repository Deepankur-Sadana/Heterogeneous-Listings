package vaibhav.com.heterolistings.core;

/**
 * Created by Vaibhav on 11/27/15.
 */
public enum TemplateType {
    TYPE1(1, "product-template-1"),
    TYPE2(2, "product-template-2"),
    TYPE3(3, "product-template-3");

    final int identifier;
    final String name;

    TemplateType(final int identifier, final String name) {
        this.identifier = identifier;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return identifier;
    }
}
