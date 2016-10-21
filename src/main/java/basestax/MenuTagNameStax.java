package basestax;

import basesax.MenuTagName;

/**
 * Created by Iryna_Filipava1 on 10/18/2016.
 */
public enum MenuTagNameStax {
    TYPE("type"),
    PHOTO("photo"),
    NAME("name"),
    DESCRIPTION("description"),
    PORTION("portion"),
    PRICE("price"),
    VALUE("value"),
    DISH("dish"),
    OPTION("name"),
    DISHES("dishes");

    private String value;

    MenuTagNameStax(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }

    public static MenuTagNameStax getElementTagName(String element) {
        switch (element) {
            case "type":
                return TYPE;
            case "photo":
                return PHOTO;
            case "name":
                return NAME;
            case "description":
                return DESCRIPTION;
            case "portion":
                return PORTION;
            case "price":
                return PRICE;
            case "value":
                return VALUE;
            case "dish":
                return DISH;
            case "option":
                return OPTION;
            case "dishes":
                return DISHES;
            default:
                throw new EnumConstantNotPresentException(MenuTagName.class, element);
        }
    }
}