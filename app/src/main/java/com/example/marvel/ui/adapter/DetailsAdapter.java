package com.example.marvel.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.marvel.R;
import com.example.marvel.model.AdapterModel;

import java.util.ArrayList;

public class DetailsAdapter extends RecyclerView.Adapter<DetailsAdapter.DetailViewHolder>{
    ArrayList<AdapterModel> list = new ArrayList<>();
    AdapteItemClickListener adapteItemClickListener;

    public void setAdapteItemClickListener(AdapteItemClickListener adapteItemClickListener) {
        this.adapteItemClickListener = adapteItemClickListener;
    }

    @NonNull
    @Override
    public DetailsAdapter.DetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_element_detail,parent,false);
        return new DetailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailsAdapter.DetailViewHolder holder, int position) {
        AdapterModel model = list.get(position);

        holder.title.setText(model.getName());
        Glide.with(holder.imageViewDetail.getContext()).load(model.getThumbnail()).into(holder.imageViewDetail);

    }

    public void setList(ArrayList<AdapterModel> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class DetailViewHolder extends RecyclerView.ViewHolder
    {

        ImageView imageViewDetail;
        TextView title;

        public DetailViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewDetail = itemView.findViewById(R.id.img_row_element_detail_image);
            title = itemView.findViewById(R.id.txt_row_element_detail_title);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (adapteItemClickListener!= null && getAdapterPosition() != RecyclerView.NO_POSITION)
                    {
                        adapteItemClickListener.onAdapterItemClickListener(list.get(getAdapterPosition()));
                    }
                }
            });


        }
    }

    public interface AdapteItemClickListener{
        void onAdapterItemClickListener(AdapterModel model);

    }

}
