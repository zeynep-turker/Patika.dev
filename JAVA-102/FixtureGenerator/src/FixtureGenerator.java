import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;


public class FixtureGenerator {
    private final ArrayList<Team> teams;
    private final ArrayList<Team> homes;
    private final ArrayList<Team> aways;
    private int teamNumber = 0;

    public FixtureGenerator() {
        this.teams = new ArrayList<>();
        this.homes = new ArrayList<>();
        this.aways = new ArrayList<>();
        this.getTeams();
    }

    public void getTeams() {
        Scanner in = new Scanner(System.in);
        System.out.print("Kaç takım gireceksiniz: ");
        this.teamNumber = in.nextInt();

        for(int i=0; i<this.teamNumber; ++i) {
            in = new Scanner(System.in);
            System.out.print((i+1) + ". Giriniz: ");
            String teamName = in.nextLine();
            Team team = new Team(teamName);
            this.teams.add(team);
        }

        if(this.teamNumber % 2 != 0) {
            this.teamNumber++;
            Team team = new Team("Bay");
            this.teams.add(team);
        }
        this.matchTeams();
        this.createRounds();
    }

    public void matchTeams() {
        for(int i=0; i<teamNumber; ++i) {
            Team home = teams.get(i);
            for(int j=0; j<teamNumber; ++j){
                if(!teams.get(i).getName().equals(teams.get(j).getName())){
                    Team away = teams.get(j);
                    homes.add(home);
                    aways.add(away);
                }
            }
        }
    }

    public void createRounds() {
        int roundNum = homes.size() / (teamNumber/2);
        for(int i=0; i<roundNum; ++i) {
            System.out.println("\nRound " + (i+1));
            HashSet<String> set = new HashSet<>();
            for(int j=0; j<teamNumber/2; ++j) {
                int random = (int) Math.floor(Math.random() * (homes.size() - 1 + 1) + 1);

                while (set.contains(homes.get(random-1).getName()) || set.contains(aways.get(random-1).getName())) {
                    random = (int) Math.floor(Math.random() * (homes.size() - 1 + 1) + 1);
                }

                System.out.println(homes.get(random-1).getName() + " vs " + aways.get(random-1).getName());
                set.add(homes.get(random-1).getName());
                set.add(aways.get(random-1).getName());
                homes.remove(random-1);
                aways.remove(random-1);
            }
        }
    }
}
