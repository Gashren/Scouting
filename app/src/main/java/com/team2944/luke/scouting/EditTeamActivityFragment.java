package com.team2944.luke.scouting;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.team2944.luke.scouting.R;


/**
 * A placeholder fragment containing a simple view.
 */
public class EditTeamActivityFragment extends Fragment {

    public EditTeamActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_edit_team, container, false);
    }
}
