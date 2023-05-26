import com.codeborne.selenide.commands.TakeScreenshot;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ListenerTest implements TestWatcher { //Тестовая наблюдалка
/**
 * реализует логику тогда когда:
 * testDisabled
 * testSuccessful
 * testAborted
 * testFailed
 * в аргумент получаем context(все переменные которые применяются в процессе выполнение теста с любым мадификатором доступа)
 * грубо говоря это java reflection - это механизм исследования данных о программе во время её выполнения.
 */
@Override
public void testFailed(ExtensionContext context, Throwable cause) {
    // Если переменная не static
//    Object instance = context.getRequiredTestInstance();
//    WebDriver driver = instance.getClass().getDeclaredField("driver").get(instance);
    Allure.getLifecycle().addAttachment(
            "screenshot", "image/png", "png"
            , ((TakesScreenshot) BaseSeleniumTest.driver).getScreenshotAs(OutputType.BYTES)
    );
    BaseSeleniumTest.driver.close();
    BaseSeleniumTest.driver.quit();
}
}
