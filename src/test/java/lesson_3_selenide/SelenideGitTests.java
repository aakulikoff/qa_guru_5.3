package lesson_3_selenide;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class SelenideGitTests {

    @Test
    void selenideGithubTest() {

        open("https://github.com/");
        $(byName("q")).setValue("Selenide").pressEnter();
        $(".repo-list").shouldHave(text("selenide/selenide"));
        $(byLinkText("selenide/selenide")).click();
        $(byText("Wiki")).click();
        $(byText("Soft assertions")).shouldBe(Condition.visible).click();
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class"));

    }


    @Test
    void dragAndDropTest() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#columns").should(appear);
        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));
        $("#column-a").dragAndDropTo("#column-b");
//        Selenide.actions().dragAndDrop($("#column-a"),$("#column-b"));
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));


    }
}
