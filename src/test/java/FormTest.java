import Pages.RegistrationPage;
import org.junit.jupiter.api.Test;

public class FormTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillFormTest() {
        String userName = "Anastasiya",
                userLastName = "Zak",
                Email = "stasia-oops@yandex.ru",
                gender = "Female",
                Phone = "8927111111",
                Subjects = "Arts",
                Hobbies = "Music",
                State = "NCR",
                City = "Noida",
                Address = "Samara",
                File = "pictures/img1.png";

        new RegistrationPage().openPage()
                .setFirstName(userName)
                .setLastName(userLastName)
                .setEMail(Email)
                .setGender(gender)
                .setPhone(Phone)
                .setBirthDate("27", "May", "1991")
                .setSubjects(Subjects)
                .setHobbies(Hobbies)
                .setAddress(Address)
                .setState(State)
                .setCity(City)
                .addFile(File)
                .setSubmit();


        registrationPage.verifyResultsModalAppears()
                .verifyResults("Student Name", "Zak Anastasiya")
                .verifyResults("Student Email", "stasia-oops@yandex.ru")
                .verifyResults("Gender", "Female")
                .verifyResults("Mobile", "8927111111")
                .verifyResults("Date of Birth", "27 May,1991")
                .verifyResults("Subjects", "Arts")
                .verifyResults("Hobbies", "Music")
                .verifyResults("Picture", "img1.png")
                .verifyResults("Address", "Samara")
                .verifyResults("State and City", "NCR Noida");

    }
}