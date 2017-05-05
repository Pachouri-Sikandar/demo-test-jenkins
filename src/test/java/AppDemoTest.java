import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by ankit on 5/5/17.
 */
public class AppDemoTest {
    private static final String TEST_OBJECT_API_KEY = "9CACE93B5E07416B8EB943D823828924";
    private static final String TEST_OBJECT_DEVICE = "LG_Nexus_5X_real";
    private AppiumDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        //Building desiring capabilities. These are sent to the appium server to install the app on the particular device
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String apiKey = TEST_OBJECT_API_KEY;
        String deviceId = TEST_OBJECT_DEVICE;
        capabilities.setCapability("testobject_api_key", apiKey);
        capabilities.setCapability("testobject_device", deviceId);
        driver = new AndroidDriver(new URL("http://appium.testobject.com/wd/hub"), capabilities); //initialising the AppiumDriver with host url and capabilities
    }

    @After
    public void tearDown() {
        driver.quit(); //quit the driver, after test completion
    }

    //Write your test here
    @Test
    public void testMethod() throws InterruptedException {
        String appPackageName = "com.pachouri.demotestapp";
        String concatId = ":id/";
        By buttonClick = By.id(appPackageName + concatId + "buttonFirst");
        driver.findElement(buttonClick).click(); //click event on search image
        Thread.sleep(5000); //hold for 5 seconds after the button is clicked, this is just to see the result
    }
}
