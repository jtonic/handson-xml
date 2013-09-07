###This project is intended to learn in depth java XML technologies such as JAXP (DOM, StAX, SAX), JAXB, XPath, XSLT.

####The project is based on Java 1.7, java XML technologies, testng and maven.

1. [V] simple xpath example:

    Test: ro.jtonic.handson.XPathTest.testSimpleXPath

    before run the test copy employees.xml to /tmp (temporal solution)
    $ mvn test

1. [V] A pretty complicated xpath expression when a parent's attribute is requested, applying some checks on its hierarchy elements.
    See:
        ro.jtonic.handson.xml.ProvisionItemDiyBlogTest
        /bloginfo.xml

1. [NEXT] A simple JAXB example


Hints:
    To simplify XPAth check use the Idea support:

    - select the xml file

    - hit Ctrl+X+E




