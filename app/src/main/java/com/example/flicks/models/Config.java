package com.example.flicks.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Config {
    // the base url for loadind images
    String imageBaseUrl;
    // the poster size to use when fetching images,part of the url
    String posterSize;
    // the backdrop size to use when fetching images
    String backdropSize;



    public Config(JSONObject object) throws JSONException {
        JSONObject images = object.getJSONObject("images");
        imageBaseUrl = images.getString("secure_base_url");
        JSONArray posterSizeOptions = images.getJSONArray("poster_sizes");
        posterSize = posterSizeOptions.optString(3, "w342");
        // parse the backdrop sizes and use the option at index 1 or w780 as a fall back
        JSONArray backdropSizeOptions = images.getJSONArray("backdrop_sizes");
        backdropSize = backdropSizeOptions.optString(1, "w780");


    }
// helper method for creating url


    public String getImageUrl(String posterSize, String path) {
        return String.format("%s%s%s", imageBaseUrl, posterSize, path);
        // concatenate all three
    }

    public String getImageBaseUrl() {
        return imageBaseUrl;
    }

    public String getBackdropSize() {
        return backdropSize;

    }
    public String getPosterSize(){
        return posterSize;
    }




}






