package com.team2944.luke.scouting;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.melnykov.fab.FloatingActionButton;

import java.util.ArrayList;

import com.team2944.luke.scouting.R;
import com.team2944.luke.scouting.Team;
import com.team2944.luke.scouting.TeamsListAdapter;


public class MainActivity extends ActionBarActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<Team> teams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.teams_view);

        //improve performance by setting the size to fixed
        mRecyclerView.setHasFixedSize(true);

        //use linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        //create an adapter
        initalizeData();
        mAdapter = new TeamsListAdapter(teams);
        mRecyclerView.setAdapter(mAdapter);

        //Get the floating action button and attach it to the recycler view
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.attachToRecyclerView(mRecyclerView);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //create some dummy data to populate the list
    public void initalizeData()
    {
        teams = new ArrayList<>();
        teams.add(new Team(2944, "Titanium Tigers", "PiRex"));
        teams.add(new Team(2557, "SOTABots", "Bot"));
        teams.add(new Team(254, "Cheesy Poofs", "Deadlift"));
        teams.add(new Team(3216, "TREAD", "Treadbot"));
        teams.add(new Team(1983, "Skunkworks", "Skunkbot"));
    }

    public void launchNewTeam(View view)
    {
        Intent intent = new Intent(this, EditTeamActivity.class);
        startActivity(intent);
    }
}
