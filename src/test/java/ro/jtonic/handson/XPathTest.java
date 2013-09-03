package ro.jtonic.handson;

import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.FileInputStream;
import java.io.IOException;

public class XPathTest {

    @Test
    public void testSimpleXPath() throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        final DocumentBuilder builder = factory.newDocumentBuilder();
        final Document document = builder.parse(new FileInputStream("/tmp/employees.xml"));

        XPath xPath = XPathFactory.newInstance().newXPath();
        final String expression = "/Employees/Employee[@emplid='3333']/email";
        final String email = xPath.compile(expression).evaluate(document);
        System.out.println("email = " + email);
    }
}
