package com.example.marvel.ui.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.marvel.R;
import com.example.marvel.model.AdapterModel;
import com.example.marvel.ui.adapter.ImageAdapter;

public class ImageDialoge extends DialogFragment {

    AdapterModel model;

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            int width = ViewGroup.LayoutParams.MATCH_PARENT;
            int height = ViewGroup.LayoutParams.MATCH_PARENT;
            dialog.getWindow().setLayout(width, height);
        }
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.image_dialoge_fragment_layout, container, false);
        model = (AdapterModel) getArguments().getSerializable("model");

        TextView title = view.findViewById(R.id.txt_image_dialoge_name);
        title.setText(model.getName());

        RecyclerView recyclerView = view.findViewById(R.id.images_recyler_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);

        ImageAdapter imageAdapter = new ImageAdapter();
        imageAdapter.setImagesList(model.getImages());
        recyclerView.setAdapter(imageAdapter);

        return view;
    }

}
