package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {
    //locators
    final private SelenideElement
    firstNameInput = $("#firstName"),
    lastNameInput = $("#lastName"),
    userEmailInput = $("#userEmail"),
    userNumberInput = $("#userNumber"),
    subjectsInput = $("#subjectsInput"),
    currentAdressInput = $("#currentAddress"),
    uploadPicture = $("#uploadPicture"),
    selectState = $("#react-select-3-input"),
    selectCity = $("#react-select-4-input");
    //action
    public void setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
    }
    public void setLastName(String lastName) {
        lastNameInput.setValue(lastName);
    }
    public void setUserEmail(String userEmail) {
        userEmailInput.setValue(userEmail);
    }
    public void setUserNumber(String userNumber) {
        userNumberInput.setValue(userNumber);
    }
}