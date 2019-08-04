package com.example.flicks.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Config {
    // the base url for loadind images
    String imageBaseUrl;
    // the poster size to use when fetching images,part of the url
    String posterSize;

    public String getPosterSize() {
        return posterSize;
    }

    public  Config(JSONObject object) throws JSONException {
        JSONObject images = object.getJSONObject("images");
        imageBaseUrl = images.getString("secure base url");
        JSONArray posterSizeoptions = images.getJSONArray("postersizes");
        posterSize = posterSizeoptions.optString(3,"w432");



}
// helper method for creating url


    public String getImageBaseUrl(String size,String path) {
        return String.format("%s%s%s", imageBaseUrl, size, path); // concatenate all three
    }
     public String getImageBaseUrl(){
        return imageBaseUrl;
    }
}






