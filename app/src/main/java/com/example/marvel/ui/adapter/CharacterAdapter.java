package com.example.marvel.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.marvel.R;
import com.example.marvel.model.character.Character;

public class CharacterAdapter extends PagedListAdapter<Character, CharacterAdapter.CharacterViewHolder> {

    private CharacterItemClickListener characterItemClickListener;

    public CharacterAdapter() {
        super(callback);
    }

    public void setCharacterItemClickListener(CharacterItemClickListener characterItemClickListener) {
        this.characterItemClickListener = characterItemClickListener;
    }

    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_element_layout,parent,false);

        return new CharacterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterViewHolder holder, int position) {
        Character character = getItem(position);
        if (character != null)
        {
            Glide.with(holder.image.getContext()).load(character.getThumbnail().getPath()+"."+character.getThumbnail().getExtension()).into(holder.image);
            holder.title.setText(character.getName());
        }

    }
    private static DiffUtil.ItemCallback<Character> callback = new DiffUtil.ItemCallback<Character>() {
        @Override
        public boolean areItemsTheSame(@NonNull Character oldItem, @NonNull Character newItem) {
            return false;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Character oldItem, @NonNull Character newItem) {
            return false;
        }
    };


    public class CharacterViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView title;

        public CharacterViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.img_row_element_image);
            title = itemView.findViewById(R.id.txt_row_element_title);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (characterItemClickListener!= null &&getAdapterPosition()!= RecyclerView.NO_POSITION)
                    {
                        characterItemClickListener.onCharacterItemClickListener(getItem(getAdapterPosition()));
                    }
                }
            });


        }
    }

    public interface CharacterItemClickListener{
        void onCharacterItemClickListener(Character character);
    }

}
