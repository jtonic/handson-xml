package ro.jtonic.handson.xml

import org.testng.annotations.Test
import org.w3c.dom.Document
import org.w3c.dom.Node
import org.xml.sax.SAXException

import javax.xml.bind.JAXBContext
import javax.xml.bind.Unmarshaller
import javax.xml.parsers.DocumentBuilder
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.parsers.ParserConfigurationException
import javax.xml.xpath.XPath
import javax.xml.xpath.XPathConstants
import javax.xml.xpath.XPathExpressionException
import javax.xml.xpath.XPathFactory

import static org.fest.assertions.Assertions.assertThat

public class XPathTest {

    @Test
    void testSimpleXPath() throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        XPath.class.getResourceAsStream('/employees.xml').withStream {
            final DocumentBuilder builder = factory.newDocumentBuilder()
            final Document document = builder.parse(it)
            XPath xPath = XPathFactory.newInstance().newXPath()
            final String expression = '/Employees/Employee[@emplid=\'3333\']/email'
            final String email = xPath.compile(expression).evaluate(document)
            println "email = $email"
        }
    }


}
