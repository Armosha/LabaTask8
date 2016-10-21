package basedom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Iryna_Filipava1 on 10/21/2016.
 */
public class DomParser {
    public DomParser() {
    }

    public List<DishDom> getDishlist() throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
        f.setValidating(false);
        DocumentBuilder builder = f.newDocumentBuilder();
        Document doc = builder.parse(new File(this.getClass().getClassLoader().getResource("menu.xml").getPath()));
        List<DishDom> dishlist = new ArrayList<DishDom>();
        NodeList nodes = doc.getElementsByTagName("dish");
        NodeList node = doc.getElementsByTagName("option");

        for (int i = 0; i < nodes.getLength(); i++) {

            DishDom dish = new DishDom();

            Node fstNode = nodes.item(i);

            if (fstNode.getNodeType() == Node.ELEMENT_NODE) {

                Element fstElmnt = (Element) fstNode;

                String datatype = fstElmnt.getElementsByTagName("type").item(0).getTextContent();
                dish.setType(datatype);

                String dataphoto = fstElmnt.getElementsByTagName("photo").item(0).getTextContent();
                dish.setPhoto(dataphoto);

                String dataname = fstElmnt.getElementsByTagName("name").item(0).getTextContent();
                dish.setName(dataname);

                String dataportion = fstElmnt.getElementsByTagName("portion").item(0).getTextContent();
                dish.setPortion(dataportion);

                String datavalue = fstElmnt.getElementsByTagName("price").item(0).getTextContent();
                dish.setValue(datavalue);


                if (fstElmnt.getElementsByTagName("description").getLength() > 0) {
                    String datadescription = fstElmnt.getElementsByTagName("description").item(0).getTextContent();
                    dish.setDescription(datadescription);
                }

                NodeList l = fstElmnt.getElementsByTagName("option");
                for (int j = 0; j < l.getLength(); j++) {
                    dish.getOption().add(((Element) l.item(j)).getAttribute("name"));
                    dish.getPrice().add(((Element) l.item(j)).getTextContent());
                }
            }

            dishlist.add(dish);
        }
        return dishlist;
    }
}
