import java.util.Random;

public class Hero {
    private String name;
    private int hitPoints;

    public Hero(String name){
        this.name = name;
        hitPoints = 100;
    }

    public String getName(){
        return name;
    }

    public int getHitPoints(){
        return hitPoints;
    }

    public String toString(){
        return "Hero{name='" + name + "', hitPoints=" + hitPoints + "}";
    }

    public void attack(Hero opponent){
        Random rand = new Random();
        double upperbound = 0.99;
        double random = rand.nextDouble(upperbound);
        if(random < 0.5){
            opponent.hitPoints = opponent.hitPoints - 10;
        }

        else if(random >= 0.5){
            hitPoints = hitPoints - 10;
        }
    }

    public void senzuBean(){
        hitPoints = 100;
    }

    private void fightUntilTheDeathHelper(Hero opponent){
        while(opponent.hitPoints != 0 && hitPoints != 0){
            attack(opponent);
        }
    }

    public String fightUntilTheDeath(Hero opponent){
        opponent.senzuBean();
        senzuBean();
        fightUntilTheDeathHelper(opponent);
        return name + ": " + hitPoints + opponent.name + ": " + opponent.hitPoints;
    }

    private int[] nFightsToTheDeathHelper(Hero opponent, int n){
        int win = 0;
        int opponentWin = 0;
        for(int i = 0; i < n; i++){
            fightUntilTheDeath(opponent);
            if(opponent.hitPoints > 0){
                opponentWin++;
            }
            else if(this.hitPoints > 0){
                win++;
            }
        }
        int[] result = {win, opponentWin};
        return result;

    }

    public String nFightsToTheDeath(Hero opponent, int n){
        int[] result = nFightsToTheDeathHelper(opponent, n);

        if(result[0] > result[1]){
            return name + ": " + result[0] + " wins\n" + opponent.name + ": " + result[1] + " wins\n" + name + " wins!";
        }

        else if(result[0] < result[1]){
            return name + ": " + result[0] + " wins\n" + opponent.name + ": " + result[1] + " wins\n" + opponent.name + " wins!";
        }

        else{
            return name + ": " + result[0] + " wins\n" + opponent.name + ": " + result[1] + " wins\n" + "OMG! It was actually a draw!";
        }
    }

    public void dramaticFightToTheDeath(Hero opponent){
        while(opponent.hitPoints != 0 || hitPoints != 0){
            attack(opponent);
            System.out.println(name + ": " + hitPoints + "\t" + opponent.name + ": " + opponent.hitPoints);
        }

        if(opponent.hitPoints == 0){
            System.out.println(name + " wins!");
        }

        if(hitPoints == 0){
            System.out.println(opponent.name + " wins!");
        }
    }

}