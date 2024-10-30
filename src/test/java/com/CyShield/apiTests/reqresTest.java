package com.CyShield.apiTests;

import com.CyShield.api.apis.reqresAPI;
import com.CyShield.api.utils.ApiResponse;
import org.testng.annotations.Test;

public class reqresTest extends BaseApiTest {

    String userID;

    @Test(priority = 1, description = "test list of users")
    public void getListOfUsersTest() {
        ApiResponse response = reqresAPI.getUsers(2);
        System.out.println("list of users response: " + response);

        softAssert().assertEquals(response.getStatusCode(), 200);
        softAssert().assertAll();
    }

    @Test(priority = 2, description = "create user")
    public void createUserTest() {
        ApiResponse response = reqresAPI.createUser("khalid", "QC");
        userID = response.getObjectFromBody("id");
        System.out.println("create user response: " + response);
        System.out.println("newly created user id is: " + userID);

        softAssert().assertEquals(response.getStatusCode(), 201);
        softAssert().assertTrue(response.getTime() < 1000);
        softAssert().assertAll();
    }

    @Test(priority = 3, description = "update user")
    public void updateUserTest() {
        ApiResponse response = reqresAPI.updateUser(userID, "khalid edit", "QC");
        System.out.println("update user response: " + response);

        softAssert().assertEquals(response.getStatusCode(), 200);
        softAssert().assertTrue(response.getTime() < 1000);
        softAssert().assertAll();
    }

}
