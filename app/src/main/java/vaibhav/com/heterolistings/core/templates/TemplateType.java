package vaibhav.com.heterolistings.core.templates;

/**
 * Created by Vaibhav on 11/27/15.
 *
 * Enum that stores types of templates being used in the application
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

    /**
     *
     * @return: name of the template that appears in the incoming JSON response
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return: identifier of the template type used through out the application
     */
    public int getId() {
        return identifier;
    }
}
