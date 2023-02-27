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

        $("#userNumber").setValue("8999000112");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOptionByValue("1965");
        $(".react-datepicker__month-select").selectOptionByValue("11");
        $(".react-datepicker__day--007").click();

        $("#subjectsInput").setValue("bio");
        $(byText("Biology")).click();

        $(byText("Music")).click();

        $("#uploadPicture").uploadFile(new File("src/resourse/img/img.png"));

        $("#currentAddress").setValue("Paris");

        $("#react-select-3-input").setValue("NCR").pressEnter();

        $("#react-select-4-input").setValue("Delhi").pressEnter();

        $("#submit").click();

        $(".modal-header").shouldHave(text("Thanks for submitting the form"));

        $(".table-responsive").shouldHave(text("Student Name Vasya Pupkin"), text("Student Email test@test.nur"), text("Gender Other"),
                text("Mobile 8999000112"), text("Date of Birth 07 December,1965"), text("Subjects Biology"), text("Hobbies Music"),
                text("Picture img.png"), text("Address Paris"), text("State and City NCR Delhi"));
    }
}