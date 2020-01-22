package com.example.marvel.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.marvel.network.DataStatus;
import com.example.marvel.R;
import com.example.marvel.model.character.Character;
import com.example.marvel.model.comic.Comic;
import com.example.marvel.model.event.Event;
import com.example.marvel.model.series.Series;
import com.example.marvel.model.story.Story;
import com.example.marvel.ui.adapter.CharacterAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements DataStatus {
    MainViewModel mainViewModel;
    RecyclerView recyclerView;
    CharacterAdapter characterAdapter;
    ProgressBar progressBar;
    DataStatus dataStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progressbar_main_activity);

        getSupportActionBar().setIcon(R.drawable.ic_icn_nav_marvel);


        recyclerView = findViewById(R.id.recycler_view_main);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        characterAdapter = new CharacterAdapter();

        loadData(null);


        recyclerView.setAdapter(characterAdapter);

        characterAdapter.setCharacterItemClickListener(new CharacterAdapter.CharacterItemClickListener() {
            @Override
            public void onCharacterItemClickListener(Character character) {

                Intent intent = new Intent(getBaseContext(), DetailsActivity.class);
                intent.putExtra("ShowDetails",character);
                startActivity(intent);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.search_menu, menu);

        MenuItem searchitem = menu.findItem(R.id.menu_search_id);

        SearchView searchView = (SearchView) searchitem.getActionView();
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (newText == null || newText.length()==0)
                {
                    loadData(null);
                }else
                {
                    loadData(newText);
                }
                return false;
            }
        });

        return true;
    }

    void loadData(String query) {
        progressBar.setVisibility(View.VISIBLE);
        mainViewModel.getCharacterList(query,this).observe(this, new Observer<PagedList<Character>>() {
            @Override
            public void onChanged(PagedList<Character> characters) {
                Log.d("mainActivity", "done");
                characterAdapter.submitList(characters);

            }
        });

    }

    @Override
    public void onSucess(String status) {
        progressBar.setVisibility(View.INVISIBLE);

    }

    @Override
    public void onComicSucess(String status, ArrayList<Comic> comicList) {

    }

    @Override
    public void onEventSucess(String status, ArrayList<Event> eventArrayList) {

    }

    @Override
    public void onSeriesSucess(String status, ArrayList<Series> seriesArrayList) {

    }

    @Override
    public void onStoriesSucess(String status, ArrayList<Story> storyArrayList) {

    }

    @Override
    public void onFailure(String status) {
        progressBar.setVisibility(View.INVISIBLE);
        Toast.makeText(this, "Failed to load Data", Toast.LENGTH_SHORT).show();

    }
}
