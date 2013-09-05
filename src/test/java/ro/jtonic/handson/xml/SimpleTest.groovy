package ro.jtonic.handson.xml

import org.testng.annotations.AfterTest
import org.testng.annotations.BeforeTest
import org.testng.annotations.Test

import static org.fest.assertions.Assertions.assertThat
/**
 * Created by jtonic on 9/5/13.
 */
class SimpleTest {

    @BeforeTest
    void setUp() {
        println "setUp"
    }

    @AfterTest
    void tearDown() {
        println "tearDown"
    }

    @Test
    void testDummy() {
        assertThat(true).isTrue()
    }

}
