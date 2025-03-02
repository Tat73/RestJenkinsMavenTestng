package org.example.tests;

import io.restassured.http.Method;
import io.restassured.response.Response;
import org.example.enums.StatusCode;
import org.example.service.ResponseService;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.Map;

import static org.example.enums.Path.USER_PATH;
import static org.hamcrest.MatcherAssert.assertThat;

public class UsersTest {

    @Test(description = "Check Status code with GET request to get all users from the 2nd page")
    public void checkUsersListStatusCode() {
        Response response = ResponseService.sendModelWithQueryParam(Method.GET, USER_PATH, Map.of("page", 2));
        assertThat("Status code is not 200 OK", response.getStatusCode(), Matchers.equalTo(StatusCode.OK.getCode()));
        assertThat("Content-Type is not 'application/json'", response.contentType(), Matchers.equalTo("application/json; charset=utf-8"));
    }

}

