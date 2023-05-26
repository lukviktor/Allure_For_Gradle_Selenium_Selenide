import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

@ExtendWith(ListenerTest.class) // реализуем интерфейс который реализован в ListenerTest.class и мы этими методами вообще не пользуемся
public class Test extends BaseSeleniumTest  {

    @Owner("Виктор Лукашев")
    @Description("Что здесь происходит?")
    public void test() {

    }
}
