import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchTests {
    @Test
    void successfulAntibotTest() {
        open("https://www.google.com/");
        $("[name=q]").setValue("selenide").pressEnter();
        $("html").shouldHave(text("Об совсем другой странице"));
    }

    @Test
    void successDuckTest() {
        Configuration.holdBrowserOpen = true;
        open("https://duckduckgo.com");
        $("[name=q]").setValue("selenide").pressEnter();
        $("[data-testid=\"about\"]").shouldHave(text("Selenide"));
    }
}