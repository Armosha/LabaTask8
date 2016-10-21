package basedom;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Created by Iryna_Filipava1 on 10/21/2016.
 */
public class MainDomParser {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        DomParser dom = new DomParser();
        System.out.println(dom.getDishlist());
    }

}
