package com.pnt.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class SpotifyPractice {

    /*
    curl -X "GET" "https://api.spotify.com/v1/search?q=pitbull&type=artist" -H
    "Accept: application/json" -H "Content-Type: application/json" -H "
     */


    public String baseURI = RestAssured.baseURI = "https://api.spotify.com/v1/";


    private String searchSongEndPoint = "artists/50IoFVJRAVmpc2tc15U0vP/top-tracks";


    @Test
    public void getZehraTopSongs() {

        Response response = RestAssured.given().when().get(searchSongEndPoint).then()
                .assertThat().statusCode(200).extract().response();


    }



}
