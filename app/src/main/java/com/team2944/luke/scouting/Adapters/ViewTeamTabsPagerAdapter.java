package com.team2944.luke.scouting.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.team2944.luke.scouting.Fragments.ViewGameInfoFragment;
import com.team2944.luke.scouting.Fragments.ViewRobotInfoFragment;
import com.team2944.luke.scouting.Fragments.ViewTeamInfoFragment;

/**
 * Created by 536034 on 6/8/2015.
 */
public class ViewTeamTabsPagerAdapter extends FragmentPagerAdapter {

    public ViewTeamTabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int index) {

        switch (index) {
            case 0:
                // team info fragment activity
                return new ViewTeamInfoFragment();
            case 1:
                // robot info fragment activity
                return new ViewRobotInfoFragment();
            case 2:
                // game info fragment activity
                return new ViewGameInfoFragment();
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
