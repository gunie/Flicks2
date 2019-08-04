package com.example.flicks.models;

import org.json.JSONException;
import org.json.JSONObject;

public class Movie<backdropPath> {

    // values from API
    private String title;
    private String overview;
    private String posterPath; // only the path
    private String backdropPath;



    // initialize from JSON data
    public Movie(JSONObject object) throws JSONException {
        title = object.getString("title");
        overview = object.getString("overiew");
        posterPath = object.getString("poster_path");
        backdropPath = object.getString("backdrop_path");
        ;

    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getBackdropPath() {
        return backdropPath;
    }
}
