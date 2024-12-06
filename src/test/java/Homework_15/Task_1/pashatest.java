package Homework_15.Task_1;
import com.google.gson.Gson;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

@Test
public class pashatest {

    public void test1() {
        // Получаю тело ответа в формате JSON
        String body = given()
                // Указываю тип контента из-за конфликтов при ответе сервера
                .header("Content-Type", "application/json")
                // Указываю, что ожидаю ответ в формате JSON из-за конфликтов при ответе сервера
                .header("Accept", "application/json")
                .when()
                .get("https://gate.21vek.by/recommendations-composer/products/9248532/recommendations?anonymousId=83d6dd2c-3959-42b0-95b0-6821959746c3")
                .then()
                .log().all()
                .extract().body().asString();

        // Логирование полученного JSON ответа
        System.out.println("Received JSON response: " + body);

        // Десериализация: преобразование ответа в объект ProductList
        ProductList productList = new Gson().fromJson(body, ProductList.class);
        System.out.println("Deserialized ProductList object: " + productList);

        // Получаем первый элемент из списка и проверяем бренд
        Attributes attributes = productList.getData().get(0).getAttributes();
        String brand = attributes.getBrand();
        System.out.println("Brand: " + brand);

        // Проверка, что бренд соответствует ожидаемому
        Assert.assertEquals(brand, "Xiaomi");

        // Сериализация: преобразование объект ProductList обратно в JSON
        String jsonOutput = new Gson().toJson(productList);
        System.out.println("Serialized JSON: " + jsonOutput);
    }
}