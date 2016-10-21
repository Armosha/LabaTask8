package basesax;


import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class MenuSaxHandler extends DefaultHandler {

    private Dish position;
    private StringBuilder s;
    private List<Dish> dishList = new ArrayList<Dish>();

    public List<Dish> getDishlist() {
        return dishList;
    }

    public MenuSaxHandler() {
    }

    @Override
    public void startDocument() {
        System.out.println("Parsing started");
    }

    @Override
    public void endDocument() {
        System.out.println("Parsing ended");
    }

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws org.xml.sax.SAXException {
        s = new StringBuilder();
        if (localName.equals("dish")) {
            position = new Dish();
        }
        if (localName.contentEquals("option")) {
            position.getOption().add((attributes.getValue("name")));
        }
    }


    @Override
    public void endElement(String uri, String localName, String qName) {
        MenuTagName tagName = MenuTagName.valueOf(localName.toUpperCase().replace("-", "_"));
        switch (tagName) {
            case TYPE:
                position.setType(s.toString());
                break;
            case PHOTO:
                position.setPhoto(s.toString());
                break;
            case NAME:
                position.setName(s.toString());
                break;
            case DESCRIPTION:
                position.setDescription(s.toString());
                break;
            case PORTION:
                position.setPortion(s.toString());
                break;
            case VALUE:
                position.setValue(s.toString());
                break;
            case OPTION:
                position.getPrice().add(s.toString());
                break;
            case DISH:
                dishList.add(position);
                position = null;
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        s.append(ch, start, length);
    }
}
