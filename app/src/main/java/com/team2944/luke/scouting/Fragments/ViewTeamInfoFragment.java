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
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_view_team_info, container, false);

        teamNumber = (TextView) getActivity().findViewById(R.id.view_team_number);
        teamName = (TextView) getActivity().findViewById(R.id.view_team_name);
        teamLocation = (TextView) getActivity().findViewById(R.id.view_team_location);
        teamNotes = (TextView) getActivity().findViewById(R.id.view_team_notes);

        return view;
    }

    public void setTeamNumberText(String text){
        teamNumber.setText(text);
    }
}
