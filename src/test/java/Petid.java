
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test ;



public  class Petid {
   @Test
    public void testPet(){
        RestAssured.given()
                .baseUri("http://petstore.swagger.io") //ресурс для запроса
                .basePath("/v2/pet ")  //путь с которого запрашиваем данные
                .header("api_key", "9i9i9i9i9i9i") //логинимся для доступа
                .contentType(ContentType.JSON)
                .when().get("1")// запрашиваем порядковый номер питомца информацию о котором хотим получить
                .then()
                .statusCode(200)   //проверяем, что сервис доступен
                .extract().response()
                .prettyPrint();
    }
}
