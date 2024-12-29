package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

public class SearchRepoGet {

    @Test
    public void testSearchRepository() {
        // Вказуємо базовий URL для GitHub API
        RestAssured.baseURI = "https://api.github.com";

        // Створюємо параметри запиту
        String query = "selenium";

        // Виконуємо GET запит до пошукового API
        Response response = RestAssured
                .given()
                .queryParam("q", query)
                .when()
                .get("/search/repositories");

        // Перевіряємо статус-код відповіді
        Assert.assertEquals(200, response.getStatusCode());

        // Виводимо тіло відповіді
        System.out.println("Body: " + response.getBody().asString());

        // Додаткова перевірка: переконайтеся, що результат містить запитуваний термін
        Assert.assertTrue(response.getBody().asString().contains("selenium"));
    }
}
