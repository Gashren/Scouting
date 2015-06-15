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
public class ViewRobotInfoFragment extends Fragment {

    public static TextView robotName;
    public static TextView robotWeight;
    public static TextView robotNotes;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_robot_info, container, false);

        robotName = (TextView) view.findViewById(R.id.view_robot_name);
        robotWeight = (TextView) view.findViewById(R.id.view_robot_weight);
        robotNotes = (TextView) view.findViewById(R.id.view_robot_notes);

        return view;
    }
}
