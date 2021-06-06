package game;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class Bundesliga {

    List<Team> teams = new ArrayList<>();
    MatchDay matchDay = new MatchDay();

    private int teamStrength;

    public int getTeamStrength() {
        return teamStrength;
    }

    public void setTeamStrength(int teamStrength) {
        this.teamStrength = teamStrength;
    }

    public void addTeam(Team team) {
        teams.add(team);
    }

    public boolean hasEnoughTeams() {
        return teams.size() == 18;
    }

    public void generateTeams(){
        String fileName = "teams.txt";
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.forEach(teamName -> teams.add(new Team(teamName)));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public int numberOfTeams() {
        return teams.size();
    }

    public MatchDay generateMatches() {
//        fixme: generate matches from all teams
        int matches = teams.size()/2;
        MatchDay matchDay = new MatchDay();
        int index = 0;

        for (int i=0; i<matches; i++){
            Game game = new Game();
            game.addTeams(teams.get(index), teams.get(index+1));
            matchDay.addGame(game);
            index+=2;
        }

        return matchDay;
    }
}