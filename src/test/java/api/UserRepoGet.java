package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

public class UserRepoGet {

    @Test
    public void testListUserRepos() {
        // Вказуємо базовий URL для GitHub API
        RestAssured.baseURI = "https://api.github.com";

        // Вказуємо ім'я користувача
        String username = "octocat";

        // Виконуємо GET запит для отримання списку репозиторіїв користувача
        Response response = RestAssured
                .given()
                .when()
                .get("/users/" + username + "/repos");

        // Перевіряємо статус-код відповіді
        Assert.assertEquals(200, response.getStatusCode());

        // Виводимо тіло відповіді
        System.out.println("Body: " + response.getBody().asString());
    }
}
