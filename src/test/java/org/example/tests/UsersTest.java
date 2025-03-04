package org.example.tests;

import io.restassured.http.Method;
import io.restassured.response.Response;
import org.example.enums.StatusCode;
import org.example.model.LoginModel;
import org.example.model.RegisterModel;
import org.example.model.User;
import org.example.service.ResponseService;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.Map;

import static org.example.enums.Path.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class UsersTest {

    @Test(description = "Get all users from the 2nd page")
    public void getUsersListAndStatusCode() {
        Response response = ResponseService.sendModelWithQueryParam(Method.GET, USER_PATH, Map.of("page", 2));
        assertThat("Status code is not 200 OK", response.getStatusCode(), Matchers.equalTo(StatusCode.OK.getCode()));
        assertThat("Content-Type is not 'application/json'", response.contentType(), Matchers.equalTo("application/json; charset=utf-8"));
    }

    @Test(description = "Create user")
    public void createUserAndStatusCode() {
        User user = User.generateModel("morpheus", "leader");
        Response userResponse = ResponseService.sendModel(Method.POST, USER_PATH, user);
        assertThat("Status code is 201 created", userResponse.getStatusCode(), Matchers.equalTo(StatusCode.CREATED.getCode()));
    }

    @Test(description = "Register a user")
    public void createRegisterAndStatusCode() {
        RegisterModel registerModel = RegisterModel.generateModel("eve.holt@reqres.in", "pistol");
        Response postResponse = ResponseService.sendModel(Method.POST, REGISTER_PATH, registerModel);
        assertThat("Status code is not 200 OK", postResponse.getStatusCode(), Matchers.equalTo(StatusCode.OK.getCode()));
    }

    @Test(description = "User`s log in")
    public void createLoginAndStatusCode() {
        LoginModel loginModel = LoginModel.generateModel("eve.holt@reqres.in", "cityslicka");
        Response postResponse = ResponseService.sendModel(Method.POST, LOGIN_PATH, loginModel);
        assertThat("Status code is not 200 OK", postResponse.getStatusCode(), Matchers.equalTo(StatusCode.OK.getCode()));
    }

}

