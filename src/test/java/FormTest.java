import Pages.RegistrationPage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class FormTest {
    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;

    }

    @Test
    void fillFormTest() {
        String userName = "Anastasiya",
                userLastName = "Zak",
                Email = "stasia-oops@yandex.ru",
                gender = "Female",
                Phone = "8927111111";

        new RegistrationPage().openPage()
                .setFirstName(userName)
                .setLastName(userLastName)
                .setEMail(Email)
                .setGender(gender)
                .setPhone(Phone);


        $(".react-datepicker-wrapper").click();
        $(".react-datepicker__year-select").$(byText("1991")).click();
        $(".react-datepicker__month-select").$(byText("June")).click();
        $(".react-datepicker__day.react-datepicker__day--027").click();

        $("#subjectsInput").setValue("Arts").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();
        ;
        $("#uploadPicture").uploadFromClasspath("pictures/img1.png");
        $("[id=currentAddress]").setValue("SamaraSamaraSamaraSamaraSamaraSamaraSamara");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Noida")).click();
        $("#submit").click();


        $(".table-responsive").shouldHave(
                text("Zak Anastasiya"),
                text("stasia-oops@yandex.ru"),
                text("Female"),
                text("8927111111"),
                text("27 May,1991"),
                text("Arts"),
                text("Music"),
                text("img1.png"),
                text("SamaraSamaraSamaraSamaraSamaraSamaraSamara"),
                text("NCR Noida"));
    }
}