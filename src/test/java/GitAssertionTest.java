import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class GitAssertionTest {

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";

    }

    @Test
    public void gitHubAssertionTests() {
        open("https://github.com/");
        $(".header-search-input").setValue("selenide").pressEnter();
        $$(".repo-list li").first().$("a").click();
        $("#wiki-tab").click();
        $("li.Box-row.wiki-more-pages.px-2.py-2", 1).$("div:nth-child(1)").shouldHave(text("SoftAssertions"));
        $("li.Box-row.wiki-more-pages.px-2.py-2", 1).$("div:nth-child(1)").click();
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class"));
    }

}
