
package basesax;


import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Dish> dish = null;
        MenuParser sax = new MenuParser();

        try {
            dish = sax.getMenuParser();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (Dish d: dish) {
            System.out.println(dish);

        }
    }
}
