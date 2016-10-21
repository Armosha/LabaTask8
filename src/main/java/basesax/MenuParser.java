package basesax;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;


public class MenuParser {

    public MenuParser() {

    }

    public List<Dish> getMenuParser() throws ParserConfigurationException, SAXException, FileNotFoundException {

        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setNamespaceAware(true);
        SAXParser parser = factory.newSAXParser();
        MenuSaxHandler handler = new MenuSaxHandler();
        try {
            parser.parse(this.getClass().getClassLoader().getResourceAsStream("menu.xml"), handler);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return handler.getDishlist();
    }
}
