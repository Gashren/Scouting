package com.team2944.luke.scouting.Activities;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.team2944.luke.scouting.Adapters.EditTeamTabsPagerAdapter;
import com.team2944.luke.scouting.Adapters.ViewTeamTabsPagerAdapter;
import com.team2944.luke.scouting.Fragments.ViewRobotInfoFragment;
import com.team2944.luke.scouting.Fragments.ViewTeamInfoFragment;
import com.team2944.luke.scouting.R;
import com.team2944.luke.scouting.Team;

import org.w3c.dom.Text;

public class ViewTeamActivity extends ActionBarActivity {

    private ViewPager viewPager;
    private ViewTeamTabsPagerAdapter mAdapter;
    private ActionBar actionBar;
    private Team team;
    private int teamIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_team);

        //get the team from the intent
        Intent intent = getIntent();
        teamIndex = intent.getIntExtra(getString(R.string.get_extra_team_index), 0);
        team = MainActivity.teams.get(teamIndex);

        // Initilization
        viewPager = (ViewPager) findViewById(R.id.pager);
        actionBar = getSupportActionBar();
        mAdapter = new ViewTeamTabsPagerAdapter(getSupportFragmentManager());


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
        assignValues();
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
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void assignValues() {
        //Update the textviews with the correct info from the team object

        ViewTeamInfoFragment.teamNumber.setText(team.number);
        ViewTeamInfoFragment.teamName.setText(team.name);
        ViewTeamInfoFragment.teamLocation.setText(team.location);
        ViewTeamInfoFragment.teamNotes.setText(team.teamNotes);

        ViewRobotInfoFragment.robotName.setText(team.robotName);
        ViewRobotInfoFragment.robotWeight.setText(team.robotWeight);
        ViewRobotInfoFragment.robotNotes.setText(team.robotNotes);
    }
}
