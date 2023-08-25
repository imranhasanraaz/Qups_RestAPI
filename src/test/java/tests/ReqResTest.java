package tests;

import io.restassured.response.Response;
import models.CreateUser;
import models.Data;
import org.apache.commons.httpclient.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.*;

import java.util.List;

import static utils.JsonUtils.isListHasValidJson;

public class ReqResTest extends BaseTest{
    private int createdUserID;
    @Test(priority = 1)
    public void validateUserList() {
        logger.info("Validate status code and Response Body is Json");
        Response getAllPostsResponse = Requests.getAllUser();
        logger.info("Getting all User");
        Assert.assertEquals(getAllPostsResponse.getStatusCode(), HttpStatus.SC_OK, "Status code is not 200");
        List<Data> posts = getAllPostsResponse.jsonPath().getList("data", Data.class);
        Assert.assertTrue(isListHasValidJson(posts), "The List of response body is not json");
        logger.info("All User validation is done");
    }

    @Test(priority = 2)
    public void validateSingleUser() {
        logger.info("Validate that Single User has correct Values");
        Response getUserWithValidID = Requests.getUserById(validUserID);
        logger.info("Getting User with ID 2");
        Data validID = getUserWithValidID.jsonPath().getObject("data", Data.class);
        Assert.assertEquals(validID.getId(), validUserID, "Id Does not matched");
        logger.info("Single user validation is done");
    }

    @Test(priority = 3)
    public void validateCreateUser(){
        CreateUser expectedUser = new CreateUser();
        expectedUser.setName(createUserName);
        expectedUser.setJob(createUserJob);
        logger.info("Send POST request to create User");
        Response createPostResponse= Requests.createUser(expectedUser);
        Assert.assertEquals(createPostResponse.getStatusCode(), HttpStatus.SC_CREATED, "Status code is not 201.");
        CreateUser actualUser = createPostResponse.getBody().as(CreateUser.class);
        createdUserID = Integer.parseInt(actualUser.getId());
        Assert.assertEquals(actualUser.getName(), expectedUser.getName(), "User is not Created");
        logger.info("User is Created");
    }
    @Test(priority = 4)
    public void updateCreatedUser() {

        logger.info("Updated Previously Created User");
        CreateUser expectedUpdatedUser = new CreateUser();
        expectedUpdatedUser.setName(updatedUserName);
        expectedUpdatedUser.setJob(updatedUserJob);
        Response updatedUser = Requests.updateUser(expectedUpdatedUser, createdUserID);
        Assert.assertEquals(updatedUser.getStatusCode(), HttpStatus.SC_OK, "Status Code does Not Match");
        CreateUser actualUpdatedUser = updatedUser.getBody().as(CreateUser.class);
        Assert.assertEquals(actualUpdatedUser.getJob(), updatedUserJob, "Updated Job Does not match");
        logger.info("User is successfully Updated");
    }

    @Test(priority = 5)
    public void deleteUser(){
        logger.info("Delete previously created User");
        Response deleteUser = Requests.deleteUser(createdUserID);
        Assert.assertEquals(deleteUser.getStatusCode(), HttpStatus.SC_NO_CONTENT, "Status Code does not matched");
    }
}
