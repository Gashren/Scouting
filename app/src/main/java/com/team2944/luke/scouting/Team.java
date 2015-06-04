package com.team2944.luke.scouting;

/**
 * Created by Luke on 5/26/2015.
 */
public class Team {
    public String number;
    public String name;
    public String location;
    public String teamNotes;
    public String robotName;
    public String robotWeight;
    public String robotNotes;

    public Team() {
    }

    public Team(String aNumber, String aName, String aRobotName) {
        number = aNumber;
        name = aName;
        robotName = aRobotName;
    }
}
