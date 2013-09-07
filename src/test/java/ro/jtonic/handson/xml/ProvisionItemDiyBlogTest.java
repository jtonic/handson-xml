package ro.jtonic.handson.xml;

import org.apache.commons.lang.StringUtils;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;
import java.io.InputStream;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by jtonic on 9/7/13.
 */
public class ProvisionItemDiyBlogTest {
    @Test
    public void testGetProvisionItemDiyBlog() {
        boolean[] status = doGetBlogState();
        final boolean isAvailable = status[0];
        final boolean isActive = status[1];
        assertThat(isAvailable).isTrue();
        assertThat(isActive).isTrue();
    }

    /**
     * resturn a 2 element array, 0-idx one is available status and 1-idx one is active
     * @return
     */
    private boolean[] doGetBlogState() {
        boolean available = false;
        boolean active = false;

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try (InputStream is = XPathTest.class.getResourceAsStream("/bloginfo.xml")) {
            final DocumentBuilder builder = factory.newDocumentBuilder();
            final Document doc = builder.parse(is);
            XPath xPath = XPathFactory.newInstance().newXPath();

            // is blog available
            String expression = "//appprovisioningitem/apps/app[@appId='blog']/webComponents/webComponent[@webComponentId='multiMediaDiary']/parent::node()/parent::node()/parent::node()/parent::node()/attribute::provisioningId";
            String appProvisioningId = (String)xPath.compile(expression).evaluate(doc, XPathConstants.STRING);
            available = StringUtils.isNotBlank(appProvisioningId);
            if (!available) {
                return new boolean[] {available, active};
            }

            // is blog active
            // is blog available
            expression = "//appprovisioningitem/appinstanceitems/appinstanceitem[appId='blog']/parent::node()/parent::node()/attribute::provisioningId";
            String appInstanceProvisioningId = (String)xPath.compile(expression).evaluate(doc, XPathConstants.STRING);
            active = appProvisioningId.equals(appInstanceProvisioningId);

        } catch (ParserConfigurationException | SAXException | XPathExpressionException | IOException e) {
            throw new DiscoveryApiException("An error has occurred while tried to discover if Blog is available and active");
        }
        return new boolean[] {available, active};
    }

}
