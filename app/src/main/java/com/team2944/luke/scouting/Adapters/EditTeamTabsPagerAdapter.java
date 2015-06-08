package com.team2944.luke.scouting.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.team2944.luke.scouting.Fragments.EditGameInfoFragment;
import com.team2944.luke.scouting.Fragments.EditRobotInfoFragment;
import com.team2944.luke.scouting.Fragments.EditTeamInfoFragment;

/**
 * Created by Luke on 5/27/2015.
 */
public class EditTeamTabsPagerAdapter extends FragmentPagerAdapter {

    public EditTeamTabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int index) {

        switch (index) {
            case 0:
                // team info fragment activity
                return new EditTeamInfoFragment();
            case 1:
                // robot info fragment activity
                return new EditRobotInfoFragment();
            case 2:
                // game info fragment activity
                return new EditGameInfoFragment();
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
