package com.team2944.luke.scouting.Fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.team2944.luke.scouting.R;

/**
 * Created by Luke on 5/27/2015.
 */
public class EditRobotInfoFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_edit_robot_info, container, false);
    }
}
