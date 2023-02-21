package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.io.File;

import static com.codeborne.selenide.Condition.image;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.module.Configuration.*;

public class TestPracticeForm {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }
    @Test
    void successFillTest() {
        open("/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));

        $("#firstName").setValue("Vasya");
        $("#lastName").setValue("Pupkin");
        $("#userEmail").setValue("test@test.nur");

        $(byText("Other")).click();

        $("#userNumber").setValue("89990001122");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOptionByValue("1965");
        $(".react-datepicker__month-select").selectOptionByValue("11");
        $(".react-datepicker__day--007").click();

        $("#subjectsInput").setValue("bio");
        $(byText("Biology")).click();

        $(byText("Music")).click();

        $("#uploadPicture").uploadFile(new File("src/resourse/image/image.jpeg"));

        $("#currentAddress").setValue("Paris");

        $("#react-select-3-input").setValue("NCR").pressEnter();

        $("#react-select-4-input").setValue("Delhi").pressEnter();

        $("#submit").click();

        sleep(1000);
    }
}
