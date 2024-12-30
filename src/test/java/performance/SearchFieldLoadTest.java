package performance;
//=================== made by SerhiiQAA =================
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SearchFieldLoadTest {

    @Test
    public void testLoad() throws InterruptedException {
        // Вказуємо базовий URL для GitHub API
        RestAssured.baseURI = "https://api.github.com";

        // Кількість паралельних запитів
        int numberOfThreads = 500;

        // Використовуємо ExecutorService для керування потоками
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);

        // Запускаємо паралельні запити
        for (int i = 0; i < numberOfThreads; i++) {
            executorService.submit(() -> {
                Response response = RestAssured
                        .given()
                        .when()
                        .get("/search/repositories?q=selenium");

                // Перевіряємо статус-код відповіді
                Assert.assertEquals(200, response.getStatusCode());

                // Виводимо тіло відповіді
                System.out.println("Thread: " + Thread.currentThread().getId() + " - Body: " + response.getBody().asString());
            });
        }

        // Чекаємо завершення всіх запитів
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
    }
}

