package com.team2944.luke.scouting.Adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.team2944.luke.scouting.R;
import com.team2944.luke.scouting.Team;

import java.util.ArrayList;

/**
 * Created by Luke on 5/26/2015.
 */
public class TeamsListAdapter extends RecyclerView.Adapter<TeamsListAdapter.TeamsViewHolder>
{

    public static ArrayList<Team> teams = new ArrayList<>();

    public static class TeamsViewHolder extends RecyclerView.ViewHolder
    {
        CardView teamsCardLayout;
        TextView teamNumber;
        TextView teamName;
        TextView robotName;

        TeamsViewHolder(View itemView)
        {
            super(itemView);
            teamsCardLayout = (CardView)itemView.findViewById(R.id.teams_card_layout);
            teamNumber = (TextView)itemView.findViewById(R.id.team_number);
            teamName = (TextView)itemView.findViewById(R.id.team_name);
            robotName = (TextView)itemView.findViewById(R.id.robot_name);
        }
    }

    public TeamsListAdapter(ArrayList<Team> aTeams)
    {
        teams = aTeams;
    }

    @Override
    public int getItemCount()
    {
        if(teams == null) {
            return 0;
        }
        return teams.size();
    }

    @Override
    public TeamsViewHolder onCreateViewHolder(ViewGroup viewGroup, int i)
    {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.teams_layout, viewGroup, false);
        TeamsViewHolder tvh = new TeamsViewHolder(v);
        return tvh;
    }

    @Override
    public void onBindViewHolder(TeamsViewHolder teamsViewHolder, int i)
    {
        teamsViewHolder.teamNumber.setText(String.valueOf(teams.get(i).number));
        teamsViewHolder.teamName.setText(teams.get(i).name);
        teamsViewHolder.robotName.setText(teams.get(i).robotName);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView)
    {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static void addTeamToList(Team team){
        teams.add(team);
    }

    public static int getTeamIndex(Team team) {
        return teams.indexOf(team);
    }

    public static ArrayList<Team> getTeamsList(){
        return teams;
    }
}
