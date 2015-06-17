package com.team2944.luke.scouting.Activities;

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
import com.team2944.luke.scouting.RecyclerItemClickListener;
import com.team2944.luke.scouting.Team;
import com.team2944.luke.scouting.Adapters.TeamsListAdapter;


public class MainActivity extends ActionBarActivity {
    private RecyclerView mRecyclerView;
    private static RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private int teamIndex;
    private Team team;

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
        mAdapter = new TeamsListAdapter(TeamsListAdapter.getTeamsList());
        mRecyclerView.setAdapter(mAdapter);

        //Get the floating action button and attach it to the recycler view
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.attachToRecyclerView(mRecyclerView);

        mRecyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent intent = new Intent(getApplicationContext(), ViewTeamActivity.class);
                        intent.putExtra(getString(R.string.get_extra_team_index), position);
                        startActivity(intent);
                    }
                })
        );

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
        if (id == R.id.main_action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //create some dummy data to populate the list
    public void initalizeData()
    {
        TeamsListAdapter.addTeamToList(new Team("2944", "Titanium Tigers", "PiRex"));
        TeamsListAdapter.addTeamToList(new Team("2557", "SOTABots", "Bot"));
        TeamsListAdapter.addTeamToList(new Team("254", "Cheesy Poofs", "Deadlift"));
        TeamsListAdapter.addTeamToList(new Team("3216", "TREAD", "Treadbot"));
        TeamsListAdapter.addTeamToList(new Team("1983", "Skunkworks", "Skunkbot"));
    }

    public void launchNewTeam(View view) {
        Intent intent = new Intent(this, EditTeamActivity.class);
        team = new Team();
        TeamsListAdapter.addTeamToList(team);
        teamIndex = TeamsListAdapter.getTeamIndex(team);
        intent.putExtra(getString(R.string.get_extra_team_index), teamIndex);
        startActivity(intent);
    }

    public static void notifyDataSetChangedWrapper(){
        mAdapter.notifyDataSetChanged();
    }
}
