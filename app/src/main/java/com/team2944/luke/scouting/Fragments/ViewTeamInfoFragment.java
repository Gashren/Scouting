package com.team2944.luke.scouting.Fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.team2944.luke.scouting.R;

/**
 *
 */
public class ViewTeamInfoFragment extends Fragment {

    public static TextView teamNumber;
    public static TextView teamName;
    public static TextView teamLocation;
    public static TextView teamNotes;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_team_info, container, false);

        teamNumber = (TextView) view.findViewById(R.id.view_team_number);
        teamName = (TextView) view.findViewById(R.id.view_team_name);
        teamLocation = (TextView) view.findViewById(R.id.view_team_location);
        teamNotes = (TextView) view.findViewById(R.id.view_team_notes);

        return view;
    }

}
