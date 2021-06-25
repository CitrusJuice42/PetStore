
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test ;



public  class Petid {

   @Test
    public void testPet(){
        RestAssured.given()
                .baseUri("https://petstore.swagger.io") //ресурс для запроса
                .basePath("/v2/pet ")  //путь с которого запрашиваем данные
                .header("api_key", "9i9i9i9i9i9i") //логинимся для доступа
                .contentType(ContentType.JSON)
                .when().get("1")// запрашиваем порядковый номер питомца информацию о котором хотим получить
                .then()
                .statusCode(200)   //проверяем код ответа
                .extract().response()
                .prettyPrint();
                }

    @Test
    public void testPetDel(){
        RestAssured.given()
                .baseUri("https://petstore.swagger.io")
                .basePath("/v2/pet ")
                .header("api_key", "9i9i9i9i9i9i")
                .contentType(ContentType.JSON)
                .when().delete("5")
                .then()
                .statusCode(200)
                .extract().response()
                .prettyPrint();
    }
    @Test
    public void PostPet(){
        RestAssured.given()
                .baseUri("https://petstore.swagger.io") //ресурс для запроса
                .basePath("/v2/pet ")  //путь с которого запрашиваем данные
                .header("api_key", "9i9i9i9i9i9i") //логинимся для доступа
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(" { \n " +
                        "   \"id\":"+2+",\n" +
                        "   \"name\":\"kitty\",\n" +
                        "   \"photoUrls\":[] ,\n"+
                        "   \"tags\":[],\n"+
                        "   \"status\":\"available\",\n"+"}")

                .when().post()
                .then()
                .extract().response()
                .prettyPrint();
    }
}
