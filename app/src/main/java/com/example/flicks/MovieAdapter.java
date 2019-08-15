package com.example.flicks;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.Resource;
import com.example.flicks.models.Config;
import com.example.flicks.models.Movie;

import java.util.ArrayList;

public class MovieAdapter extends  RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    ArrayList<Movie>movies;
    // config needed for image urls
    Config config;
    // context for rendering
     Context context;





    public MovieAdapter(ArrayList<Movie> movies){
        this.movies = movies;
    }

    public Config getConfig() {
        return config;
    }

    public void setConfig(Config config) {
        this.config = config;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
          context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View movieView = inflater.inflate(R.layout.item_movie, viewGroup,false);
        return new ViewHolder(movieView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Movie movie = movies.get(i);
        viewHolder.tvTitle.setText(movie.getTitle());
        viewHolder.tvOverview.setText(movie.getOverview());

        // determine the current orientation
        boolean isPortrait = context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT;

        // build url for poster image
        String imageUrl = null;
        // if in portrait mode,load the poster image
        if (isPortrait) {
            imageUrl = config.getImageUrl(config.getPosterSize(), movie.getPosterPath());
        } else {
            // load the backdrop image
            imageUrl = config.getImageUrl(config.getBackdropSize(), movie.getBackdropPath());
        }
        int placeholderId = isPortrait ? R.drawable.flicks_movie_placeholder : R.drawable.flicks_backdrop_placeholder;
        ImageView imageView = isPortrait ? viewHolder.ivPosterImage : viewHolder.ivBackdropImage;

        // load image using glide
        Glide.with(context)
                .load(imageUrl)
//                .bitmapTransform(new RoundedCornersTransformation(context,15,0))
                .into(imageView);

//                    @Override
//                    public Resource<Bitmap> transform(Resource<Bitmap> resource, int outWidth, int outHeight) {
//                        return null;
//                    }
//
//                    @Override
//                    public String getId() {
//                        return null;
//                    }
//                })
//                .into(viewHolder.ivPosterImage);

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    // create the viewholder as a static inner class
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // track view objects
         ImageView ivPosterImage;
         ImageView ivBackdropImage;
         TextView tvTitle;
         TextView tvOverview;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // lookup view objects by id
            ivPosterImage = (ImageView) itemView.findViewById(R.id.ivPosterImage);
            ivBackdropImage = (ImageView) itemView.findViewById(R.id.ivBackdropImage);
            tvOverview = (TextView) itemView.findViewById(R.id.tvOverview);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);

        }
    }
}
