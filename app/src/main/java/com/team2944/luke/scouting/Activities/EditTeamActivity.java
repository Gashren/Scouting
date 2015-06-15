package com.team2944.luke.scouting.Activities;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.app.ActionBar;
import android.widget.EditText;
import android.widget.Toast;

import com.team2944.luke.scouting.R;
import com.team2944.luke.scouting.Adapters.EditTeamTabsPagerAdapter;
import com.team2944.luke.scouting.Team;


public class EditTeamActivity extends ActionBarActivity{
    private ViewPager viewPager;
    private EditTeamTabsPagerAdapter mAdapter;
    private ActionBar actionBar;
    private String teamNumber;
    private String teamName;
    private String teamLocation;
    private String teamNotes;
    private String robotName;
    private String robotWeight;
    private String robotNotes;
    private Team team;
    private int teamIndex;
    Context context;
    CharSequence text;
    int duration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_team);

        //Get intent from main activity so we can get the index
        //of the new team from the intent's extra
        Intent intent = getIntent();
        teamIndex = intent.getIntExtra(getString(R.string.get_extra_team_index), 0);

        // Initilization
        viewPager = (ViewPager) findViewById(R.id.pager);
        actionBar = getSupportActionBar();
        mAdapter = new EditTeamTabsPagerAdapter(getSupportFragmentManager());


        //Specify the adapter to use with the view pager
        viewPager.setAdapter(mAdapter);

        //Specify the action bar to use tabs
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        //create a tab listener
        ActionBar.TabListener tabListener = new ActionBar.TabListener() {
            public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
                // hide the given tab
            }

            public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
                // probably ignore this event
            }
        };

        // Adding Tabs
        actionBar.addTab(actionBar.newTab().setText("TEAM").setTabListener(tabListener));
        actionBar.addTab(actionBar.newTab().setText("ROBOT").setTabListener(tabListener));
        actionBar.addTab(actionBar.newTab().setText("GAME").setTabListener(tabListener));

        //update tabs when pages are switched
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                // on changing the page
                // make respected tab selected
                actionBar.setSelectedNavigationItem(position);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit_team, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.edit_action_save:
                saveTeamInfoChanges();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void getFieldValues() {
        //called to retrieve the strings from the input fields
        EditText editTextTeamNumber = (EditText) findViewById(R.id.edit_team_number);
        teamNumber = editTextTeamNumber.getText().toString();

        EditText editTextTeamName = (EditText) findViewById(R.id.edit_team_name);
        teamName = editTextTeamName.getText().toString();

        EditText editTextTeamLocatoin = (EditText) findViewById(R.id.edit_team_location);
        teamLocation = editTextTeamLocatoin.getText().toString();

        EditText editTextTeamNotes = (EditText) findViewById(R.id.edit_team_notes);
        teamNotes = editTextTeamNotes.getText().toString();

        EditText editTextRobotName = (EditText) findViewById(R.id.edit_robot_name);
        robotName = editTextRobotName.getText().toString();

        EditText editTextRobotWeight = (EditText) findViewById(R.id.edit_robot_weight);
        robotWeight = editTextRobotWeight.getText().toString();

        EditText editTextRobotNotes = (EditText) findViewById(R.id.edit_robot_notes);
        robotNotes = editTextRobotNotes.getText().toString();

    }

    public void saveTeamInfoChanges() {
        //called when save button is pressed, updates input values to team object in the teams array list
        getFieldValues();

        team = new Team();
        team.number = this.teamNumber;
        team.name = this.teamName;
        team.location = this.teamLocation;
        team.teamNotes = this.teamNotes;
        team.robotName = this.robotName;
        team.robotWeight = this.robotWeight;
        team.robotNotes = this.robotNotes;

        MainActivity.teams.set(teamIndex, team);

        //create toast for feedback
        context = getApplicationContext();
        text = "Team " + teamNumber + " saved";
        duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        //start a new view team activity for the team object we just made
        Intent intent = new Intent(this, ViewTeamActivity.class);
        intent.putExtra(getString(R.string.get_extra_team_index), teamIndex);
        startActivity(intent);

    }

}
