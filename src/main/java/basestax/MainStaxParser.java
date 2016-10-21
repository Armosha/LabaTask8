package basestax;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Iryna_Filipava1 on 10/20/2016.
 */
public class MainStaxParser {
    public static void main(String[] args) throws IOException, XMLStreamException, NullPointerException {
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        try {
            InputStream input = new FileInputStream("D:/ИРОЧКА/EPAM/xml/src/main/resources/menu.xml");
            XMLStreamReader reader = inputFactory.createXMLStreamReader(input);
            List<DishStax> dishst = process(reader);
            for (DishStax d : dishst) {
                System.out.println(d.toString());
            }
        } catch (XMLStreamException e) {
            System.out.println(e);
        }
    }

    private static List<DishStax> process(XMLStreamReader reader) throws XMLStreamException {
        List<DishStax> dishst = new ArrayList<DishStax>();
        DishStax d = null;
        MenuTagNameStax elementName = null;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    elementName = MenuTagNameStax.getElementTagName(reader.getLocalName());
                    switch (elementName) {
                        case DISH:
                            d = new DishStax();
                            break;
                        case OPTION:
                            d.getOption().add(reader.getAttributeValue(null, MenuTagNameStax.OPTION.getValue()));
                            d.getPrice().add(reader.getElementText());
                            break;
                    }
                    break;
                case XMLStreamConstants.CHARACTERS:
                    String s = reader.getText().trim();
                    if (s.isEmpty()) {
                        break;
                    }
                    switch (elementName) {
                        case TYPE:
                            d.setType(s);
                            break;
                        case PHOTO:
                            d.setPhoto(s);
                            break;
                        case NAME:
                            d.setName(s);
                            break;
                        case DESCRIPTION:
                            d.setDescription(s);
                            break;
                        case PORTION:
                            d.setPortion(s);
                            break;
                        case VALUE:
                            d.setValue(s);
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    elementName = MenuTagNameStax.getElementTagName(reader.getLocalName());
                    switch (elementName) {
                        case DISH:
                            dishst.add(d);
                    }
            }


        }
        return dishst;
    }
}