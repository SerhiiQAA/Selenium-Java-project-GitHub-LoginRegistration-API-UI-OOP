import io.gatling.core.Predef._
import io.gatling.http.Predef._

class LoadTestSimulation extends Simulation {
    val httpProtocol = http
        .baseUrl("https://api.github.com")
        .acceptHeader("application/json")

    val scn = scenario("GitHub API Load Test")
        .exec(http("Search Repositories")
        .get("/search/repositories?q=selenium")
        .check(status.is(200)))

    setUp(
        scn.inject(atOnceUsers(100)) // Налаштовуємо навантаження: одночасний запуск 100 користувачів
    ).protocols(httpProtocol)
}
