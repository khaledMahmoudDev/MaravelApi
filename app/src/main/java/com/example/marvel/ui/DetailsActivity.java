package com.example.marvel.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.marvel.network.DataStatus;
import com.example.marvel.R;
import com.example.marvel.model.AdapterModel;
import com.example.marvel.model.character.Character;
import com.example.marvel.model.character.SummaryModel;
import com.example.marvel.model.comic.Comic;
import com.example.marvel.model.event.Event;
import com.example.marvel.model.series.Series;
import com.example.marvel.model.story.Story;
import com.example.marvel.repostory.DetailsRepo;
import com.example.marvel.ui.adapter.DetailsAdapter;
import com.example.marvel.ui.fragment.ImageDialoge;

import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity implements DataStatus {
    Character character;

    RecyclerView comicsRecyclerView;
    RecyclerView seriesRecyclerView;
    RecyclerView storiesRecyclerView;
    RecyclerView eventRecyclerView;

    ArrayList<SummaryModel> comicList;
    ArrayList<SummaryModel> eventList;
    ArrayList<SummaryModel> storyList;
    ArrayList<SummaryModel> seriesList;

    ArrayList<AdapterModel> comicListAdapter;
    ArrayList<AdapterModel> eventListAdapter;
    ArrayList<AdapterModel> storyListAdapter;
    ArrayList<AdapterModel> seriesListAdapter;

    DetailsAdapter commicAdapter;
    DetailsAdapter storyAdapter;
    DetailsAdapter eventAdapter;
    DetailsAdapter seriesAdapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        comicListAdapter = new ArrayList<>();
        eventListAdapter = new ArrayList<>();
        storyListAdapter = new ArrayList<>();
        seriesListAdapter = new ArrayList<>();

        character = (Character) getIntent().getSerializableExtra("ShowDetails");

        getSupportActionBar().setTitle(character.getName());
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_icn_nav_back_white);


        TextView name = findViewById(R.id.txt_detail_name);
        name.setText(character.getName());

        ImageView mainImage = findViewById(R.id.img_detail_main);
        Glide.with(this)
                .load(character.getThumbnail().getPath() + "." + character.getThumbnail().getExtension())
                .into(mainImage);


        TextView describtion = findViewById(R.id.txt_detail_Detail);
        describtion.setText(character.getDescription());


        DetailsRepo detailsRepo = new DetailsRepo(this);

        comicList = character.getComics().getItems();
        eventList = character.getEvents().getItems();
        storyList = character.getStories().getItems();
        seriesList = character.getSeries().getItems();

        for (int i = 0; i < comicList.size(); i++) {
            String x = comicList.get(i).getResourceURI().
                    substring(comicList.get(i).getResourceURI().lastIndexOf("/") + 1);

            detailsRepo.getCommic(Integer.valueOf(x));
        }

        for (int i = 0; i < eventList.size(); i++) {
            String x = eventList.get(i).getResourceURI().
                    substring(eventList.get(i).getResourceURI().lastIndexOf("/") + 1);

            detailsRepo.getEvent(Integer.valueOf(x));
        }
        for (int i = 0; i < storyList.size(); i++) {
            String x = storyList.get(i).getResourceURI().
                    substring(storyList.get(i).getResourceURI().lastIndexOf("/") + 1);

            detailsRepo.getStory(Integer.valueOf(x));
        }
        for (int i = 0; i < seriesList.size(); i++) {
            String x = seriesList.get(i).getResourceURI().
                    substring(seriesList.get(i).getResourceURI().lastIndexOf("/") + 1);

            detailsRepo.getSeries(Integer.valueOf(x));
        }


        comicsRecyclerView = findViewById(R.id.recycler_detail_comics);
        seriesRecyclerView = findViewById(R.id.recycler_detail_series);
        storiesRecyclerView = findViewById(R.id.recycler_detail_stories);
        eventRecyclerView = findViewById(R.id.recycler_detail_event);

        commicAdapter = new DetailsAdapter();
        commicAdapter.setList(comicListAdapter);
        setRecycler(comicsRecyclerView, commicAdapter);

        storyAdapter = new DetailsAdapter();
        storyAdapter.setList(storyListAdapter);
        setRecycler(storiesRecyclerView,storyAdapter);

        eventAdapter = new DetailsAdapter();
        eventAdapter.setList(eventListAdapter);
        setRecycler(eventRecyclerView,eventAdapter);

        seriesAdapter = new DetailsAdapter();
        seriesAdapter.setList(seriesListAdapter);
        setRecycler(seriesRecyclerView,seriesAdapter);


        commicAdapter.setAdapteItemClickListener(new DetailsAdapter.AdapteItemClickListener() {


            @Override
            public void onAdapterItemClickListener(AdapterModel model) {


                if (getSupportFragmentManager()!= null)
                {
                    ImageDialoge imageDialoge = new ImageDialoge();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("model",model);
                    imageDialoge.setArguments(bundle);
                    imageDialoge.show(getSupportFragmentManager(),"ImageFragment");

                }
            }

        });




    }

    void setRecycler(RecyclerView recycler, DetailsAdapter adapter) {

        LinearLayoutManager layoutManager;
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);

        recycler.setLayoutManager(layoutManager);
        recycler.setHasFixedSize(true);
        recycler.setAdapter(adapter);
    }


    @Override
    public void onSucess(String status) {

    }

    @Override
    public void onComicSucess(String status, ArrayList<Comic> comicList) {

        AdapterModel models = new AdapterModel();
        models.setName(comicList.get(0).getTitle());
        if (comicList.get(0).getThumbnail().getPath()!= null)
        {
            models.setThumbnail(comicList.get(0).getThumbnail().getPath()+"."+comicList.get(0).getThumbnail().getExtension());
        }
        models.setImages(comicList.get(0).getImages());

        comicListAdapter.add(models);
        commicAdapter.setList(comicListAdapter);


    }

    @Override
    public void onEventSucess(String status, ArrayList<Event> eventArrayList) {
        AdapterModel models = new AdapterModel();
        models.setName(eventArrayList.get(0).getTitle());
        if (eventArrayList.get(0).getThumbnail()!= null)
        {
            models.setThumbnail(eventArrayList.get(0).getThumbnail().getPath()+"."+eventArrayList.get(0).getThumbnail().getExtension());

        }
        models.setImages(null);

        eventListAdapter.add(models);
        eventAdapter.setList(eventListAdapter);

    }

    @Override
    public void onSeriesSucess(String status, ArrayList<Series> seriesArrayList) {

        AdapterModel models = new AdapterModel();
        models.setName(seriesArrayList.get(0).getTitle());
        if (seriesArrayList.get(0).getThumbnail() != null)
        {
            models.setThumbnail(seriesArrayList.get(0).getThumbnail().getPath()+"."+seriesArrayList.get(0).getThumbnail().getExtension());

        }
        models.setImages(null);

        seriesListAdapter.add(models);
        seriesAdapter.setList(seriesListAdapter);

    }

    @Override
    public void onStoriesSucess(String status, ArrayList<Story> storyArrayList) {

        AdapterModel models = new AdapterModel();
        models.setName(storyArrayList.get(0).getTitle());
        if (storyArrayList.get(0).getThumbnail()!= null)
        {
            models.setThumbnail(storyArrayList.get(0).getThumbnail().getPath()+"."+storyArrayList.get(0).getThumbnail().getExtension());
        }
         models.setImages(null);

        storyListAdapter.add(models);
        storyAdapter.setList(storyListAdapter);

    }

    @Override
    public void onFailure(String status) {

    }
}
