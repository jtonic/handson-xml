package ro.jtonic.handson.xml;

import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by jtonic on 9/7/13.
 */
public class TestTryWithResources {

    /**
     * try with resources is not supported by Groovy 2
     */
    @Test
    public void testWithResources() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try (InputStream is = XPathTest.class.getResourceAsStream("/employees.xml")) {
            final DocumentBuilder builder = factory.newDocumentBuilder();
            final Document document = builder.parse(is);

            XPath xPath = XPathFactory.newInstance().newXPath();
            final String expression = "/Employees/Employee[@emplid='3333']/email";
            final String email = xPath.compile(expression).evaluate(document);
            System.out.println("email = " + email);
        } catch (ParserConfigurationException | SAXException | XPathExpressionException | IOException e) {
            e.printStackTrace();
        }
    }

}
