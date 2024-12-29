package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

public class SearchUsersGet {

    @Test
    public void testSearchUsers() {
        // Вказуємо базовий URL для GitHub API
        RestAssured.baseURI = "https://api.github.com";

        // Створюємо параметри запиту
        String query = "john";

        // Виконуємо GET запит до пошукового API
        Response response = RestAssured
                .given()
                .queryParam("q", query)
                .when()
                .get("/search/users");

        // Перевіряємо статус-код відповіді
        Assert.assertEquals(200, response.getStatusCode());

        // Виводимо тіло відповіді
        System.out.println("Body: " + response.getBody().asString());
    }
}


