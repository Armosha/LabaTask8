package basesax;


import java.util.ArrayList;
import java.util.List;

public class Dish {
    public String type;
    public String photo;
    public String name;
    public String description;
    public String portion;
    public String value;
    List<String> price;
    List<String> option;


    public Dish() {
        price = new ArrayList<String>();
        option = new ArrayList<String>();
    }

    public List<String> getPrice() {
        return price;
    }

    public void setPrice() {
        this.price = price;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<String> getOption() {
        return option;
    }

    public void setOption(List<String> option) {
        this.option = option;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPortion() {
        return portion;
    }

    public void setPortion(String portion) {
        this.portion = portion;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        if (option.size() != 0 && description != null) {
            str = str.append("Type of dish: " + getType())
                    .append("\n")
                    .append("Photo of dish: " + getPhoto())
                    .append("\n")
                    .append("Name of dish: " + getName())
                    .append("\n")
                    .append("Description of dish: " + getDescription())
                    .append("\n")
                    .append("Portion of dish: " + getPortion())
                    .append("\n")
                    .append("Option of dish: " + getOption())
                    .append("\n")
                    .append("Price of dish: " + getPrice())
                    .append("\n")
                    .append("\n");
        } else {
            str = str.append("Type of dish: " + getType())
                    .append("\n")
                    .append("Photo of dish: " + getPhoto())
                    .append("\n")
                    .append("Name of dish: " + getName())
                    .append("\n")
                    .append("Portion of dish: " + getPortion())
                    .append("\n")
                    .append("Price of dish: " + getValue())
                    .append("\n")
                    .append("\n");
        }

        return str.toString();
    }
}