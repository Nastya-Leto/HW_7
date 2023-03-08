package Pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private final String TITLE_TEXT = "Student Registration Form";

    public RegistrationPage openPage(){
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(Condition.text(TITLE_TEXT));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
return this;
    }

    public RegistrationPage setFirstName(String value){
        $("[id=lastName]").setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value){
        $("[id=firstName]").setValue(value);
        return this;
    }

    public RegistrationPage setEMail(String value){
        $("[id=userEmail]").setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value){
        $("#genterWrapper").$(byText(value)).click();
        return this;
    }
    public RegistrationPage setPhone(String value){
        $("[id=userNumber]").setValue(value);
        return this;
    }

}
