package com.pnt.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class SpotifyPractice {

    /*
    curl -X "GET" "https://api.spotify.com/v1/search?q=pitbull&type=artist" -H
    "Accept: application/json" -H "Content-Type: application/json" -H "
    Authorization: Bearer BQCaeO6AtImwJ6TuCJLdpWzfYNTre40DcO9YYz-qnE0oFW1KYWcbiTZW85_n0jBWpbOi_4Z1SZ8E2l__d4Ehr5OWyXPBUhUV41M9lO3-QYzhSKtQ_5TpD5uxEAe3nPqtRUa9feZ3E-OnbjZo3eoZSgGaxfykhmM"
     */

    //  Zehra id = 50IoFVJRAVmpc2tc15U0vP


    public String baseURI = RestAssured.baseURI = "https://api.spotify.com/v1/";

    private String MyToken = "BQCaeO6AtImwJ6TuCJLdpWzfYNTre40DcO9YYz";
    private String searchSongEndPoint = "artists/50IoFVJRAVmpc2tc15U0vP/top-tracks";


    @Test
    public void getZehraTopSongs() {

        Response response = RestAssured.given().when().get(searchSongEndPoint).then()
                .assertThat().statusCode(200).extract().response();

    }


}
