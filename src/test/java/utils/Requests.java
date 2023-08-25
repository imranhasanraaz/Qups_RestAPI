package utils;

import enums.EndPoints;
import io.restassured.response.Response;
import models.CreateUser;

public class Requests {
    public static Response getAllUser(){

        return APIUtils.sendGetRequest(GetUrl.getCurrentURL(EndPoints.GET.getEndpoint()));
    }

    public static Response getUserById(int id){

        return APIUtils.sendGetRequest(GetUrl.getCurrentURL(EndPoints.USER.getEndpoint() + id));
    }

    public static Response createUser(CreateUser user){

        return  APIUtils.sendPostRequest(GetUrl.getCurrentURL(EndPoints.USER.getEndpoint()), user);
    }
    public static Response updateUser(CreateUser user, int id){

        return  APIUtils.sendPutRequest(GetUrl.getCurrentURL(EndPoints.USER.getEndpoint() + id), user);
    }

    public static Response deleteUser(int id){
        return APIUtils.sendDeleteRequest(GetUrl.getCurrentURL(EndPoints.USER.getEndpoint() + id));
    }
}
