package com.team2944.luke.scouting.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.team2944.luke.scouting.Fragments.GameInfoFragment;
import com.team2944.luke.scouting.Fragments.RobotInfoFragment;
import com.team2944.luke.scouting.Fragments.TeamInfoFragment;

/**
 * Created by Luke on 5/27/2015.
 */
public class TabsPagerAdapter extends FragmentPagerAdapter {

    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int index) {

        switch (index) {
            case 0:
                // team info fragment activity
                return new TeamInfoFragment();
            case 1:
                // robot info fragment activity
                return new RobotInfoFragment();
            case 2:
                // game info fragment activity
                return new GameInfoFragment();
        }

        return null;
    }

    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        switch (position) {
            case 0:
                // Team info fragment activity
                return "TEAM";
            case 1:
                // Robot info fragment activity
                return "ROBOT";
            case 2:
                // Game info fragment activity
                return "GAME";
            default:
                return "GETPAGETITLE ERROR";

        }
    }
}
