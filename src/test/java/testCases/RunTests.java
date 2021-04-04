
package testCases;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(JUnitPlatform.class)
@SuiteDisplayName("Test Shop")
@Suite.SuiteClasses( {
        LoginTest.class,
        WishlistTest.class,
        CartTest.class } )

public class RunTests {  //this class doesn't run the test suite, without it all tests pass  !!!???

}

