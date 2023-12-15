package tests.api;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class BookingApiTest {

    private static String baseURI = "https://restful-booker.herokuapp.com";

    @Test
    public void testBookingApi() {
        String token = authenticateAndGetToken();

        int bookingId = createBooking(token);

        getAndVerifyBookingDetails(bookingId, token);

        updateBookingDetails(bookingId, token);

        getAndVerifyUpdatedBookingDetails(bookingId, token);

        checkIfBookingExists(bookingId, token);

        deleteBooking(bookingId, token);
    }

    private String authenticateAndGetToken() {
        Response response = given()
                .contentType(ContentType.JSON)
                .body("{ \"username\": \"admin\", \"password\": \"password123\" }")
                .when()
                .post(baseURI + "/auth");

        return response.jsonPath().getString("token");
    }

    private int createBooking(String token) {
        Response response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .body("{ \"firstname\": \"John\", \"lastname\": \"Doe\", \"totalprice\": 150, \"depositpaid\": true, \"bookingdates\": { \"checkin\": \"2023-01-01\", \"checkout\": \"2023-01-05\" }, \"additionalneeds\": \"Breakfast\" }")
                .when()
                .post(baseURI + "/booking");

        return response.jsonPath().getInt("bookingid");
    }

    private void getAndVerifyBookingDetails(int bookingId, String token) {
        Response response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .when()
                .get(baseURI + "/booking/" + bookingId);

        assertEquals(response.getStatusCode(), 200);
        assertEquals(response.jsonPath().getString("firstname"), "John");
    }

    private void updateBookingDetails(int bookingId, String token) {
        given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .body("{ \"totalprice\": 200 }")
                .when()
                .put(baseURI + "/booking/" + bookingId);
    }

    private void getAndVerifyUpdatedBookingDetails(int bookingId, String token) {
        Response response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .when()
                .get(baseURI + "/booking/" + bookingId);

        assertEquals(response.getStatusCode(), 200);
        assertEquals(response.jsonPath().getInt("totalprice"), 150);
    }

    private void checkIfBookingExists(int bookingId, String token) {
        Response response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .when()
                .get(baseURI + "/booking");

        assertEquals(response.getStatusCode(), 200);
        assertTrue(response.jsonPath().getList("bookingid").contains(bookingId));
    }

    private void deleteBooking(int bookingId, String token) {
        given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .when()
                .delete(baseURI + "/booking/" + bookingId);
    }
}
