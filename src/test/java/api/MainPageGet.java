package api;
//=================== made by SerhiiQAA =================
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

public class MainPageGet {

    @Test
    public void MainGet() {
        // Вказуємо базовий URL
        RestAssured.baseURI = "https://github.com/"; // Замість example.com вставте свій URL

        // Виконуємо GET запит до головної сторінки
        Response response = RestAssured
                .given()
                .when()
                .get("/");

        // Перевіряємо статус-код відповіді
        Assert.assertEquals(200, response.getStatusCode());

        // Виводимо заголовки відповіді
        System.out.println("Headers: " + response.getHeaders());

        // Виводимо тіло відповіді
        System.out.println("Body: " + response.getBody().asString());

        // Додаткові перевірки: наприклад, перевірка вмісту відповіді
        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains("Build and ship software on a single, collaborative platform"));
    }
}
