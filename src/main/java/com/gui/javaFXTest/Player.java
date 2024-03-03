package com.gui.javaFXTest;

public class Player {

    // ATTs
    private final String team;
    private final String playerName;

    // Con
    public Player(String team, String playerName) {
        this.team = team;
        this.playerName = playerName;
    }

    // GETs
    public String getTeam() {
        return team;
    }

    public String getPlayerName() {
        return playerName;
    }

    // OVRs
    @Override
    public String toString() {
        return "Player{" +
                "team='" + team + '\'' +
                ", playerName='" + playerName + '\'' +
                '}';
    }
}
