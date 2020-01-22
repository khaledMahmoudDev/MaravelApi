package com.example.marvel.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.marvel.R;
import com.example.marvel.model.character.Image;

import java.util.ArrayList;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {
    ArrayList<Image> imagesList = new ArrayList<>();

    public void setImagesList(ArrayList<Image> imagesList) {
        this.imagesList = imagesList;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_row_element,parent,false);

        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {

        Image image = imagesList.get(position);
        Glide.with(holder.imageView.getContext()).load(image.getPath()+"."+image.getExtension()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return imagesList.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder
    {

        ImageView imageView;
        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img_element_image_dialoge);

        }
    }
}
