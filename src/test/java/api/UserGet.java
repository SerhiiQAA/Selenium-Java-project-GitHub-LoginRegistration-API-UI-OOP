package api;
//=================== made by SerhiiQAA =================
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

public class UserGet {

    @Test
    public void testGetUser() {
        // Вказуємо базовий URL для GitHub API
        RestAssured.baseURI = "https://api.github.com";

        // Вказуємо ім'я користувача
        String username = "octocat";

        // Виконуємо GET запит для отримання інформації про користувача
        Response response = RestAssured
                .given()
                .when()
                .get("/users/" + username);

        // Перевіряємо статус-код відповіді
        Assert.assertEquals(200, response.getStatusCode());

        // Виводимо тіло відповіді
        System.out.println("Body: " + response.getBody().asString());
    }
}
