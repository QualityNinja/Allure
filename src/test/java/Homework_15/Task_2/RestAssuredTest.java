package Homework_15.Task_2;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class RestAssuredTest {


    private final Gson gson = new Gson();

    @Test
    public void testCreateUser() {
        // Здесь и в дальнейшем я устанавливаю базовый URL прямо в тесте
        RestAssured.baseURI = "https://reqres.in/api";

        // Создание объекта пользователя
        User user = new User();
        user.setName("John Doe");
        user.setJob("Developer");

        // Выполнение POST запроса для создания пользователя
        Response response = given()
                .header("Content-Type", "application/json")
                .body(gson.toJson(user))
                .post("/users")
                .then()
                .statusCode(201)
                .extract()
                .response();

        // Десериализация ответа обратно в объект User
        User createdUser = gson.fromJson(response.asString(), User.class);

        // Проверка, что созданный пользователь имеет id и совпадает с отправленными данными
        Assert.assertNotNull(createdUser.getId(), "ID должен быть не null");
        Assert.assertEquals(createdUser.getName(), user.getName(), "Имя должно совпадать");
        Assert.assertEquals(createdUser.getJob(), user.getJob(), "Работа должна совпадать");
    }

    // Тест для обновления данных пользователя (PUT запрос)
    @Test
    public void testUpdateUser() {

        RestAssured.baseURI = "https://reqres.in/api";

        // Создание объекта пользователя с новыми данными
        User user = new User();
        user.setName("Jane Doe");
        user.setJob("Manager");

        // Выполнение PUT запроса для обновления данных пользователя с ID 2
        Response response = given()
                .header("Content-Type", "application/json")
                .body(gson.toJson(user))
                .when()
                .put("/users/2")
                .then()
                .statusCode(200)
                .extract()
                .response();

        // Десериализация ответа обратно в объект User
        User updatedUser = gson.fromJson(response.asString(), User.class);

        // Проверка, что обновлённые данные совпадают с отправленными
        Assert.assertEquals(updatedUser.getName(), user.getName(), "Имя должно совпадать");
        Assert.assertEquals(updatedUser.getJob(), user.getJob(), "Работа должна совпадать");
    }

    // Тест для удаления пользователя (DELETE запрос)
    @Test
    public void testDeleteUser() {

        RestAssured.baseURI = "https://reqres.in/api";

        // DELETE запрос для удаления пользователя с ID 2
        given()
                .when()
                .delete("/users/2")
                .then()
                .statusCode(204);
    }
}
