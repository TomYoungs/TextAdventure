import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //System objects
        Scanner in = new Scanner(System.in);
        Random rand =  new Random();

        //Game Variables
        String[] enemies =  {"Skeleton"};
        int maxEnemyHealth = 100;
        int maxEnemyAttachDamage = 25;

        //Player Variables
        int health = 100;
        int maxAttachDamage = 50;

        boolean running = true;

        System.out.println("Welcome to the Dungeon!");
        while (running){
            System.out.println("--------------------------------------------------------------------");

            int enemyHealth = rand.nextInt(maxEnemyHealth);
            String enemy = enemies[0];//we only have one enemy here. You can add more and use random choose one.
            System.out.println("\t# "+enemy+" is appeared! #\n");

            while(enemyHealth>0){
                //Print the current HP info
                System.out.println("\tYour HP: "+health);
                System.out.println("\t"+enemy+"'s HP:"+enemyHealth);

                //Let player to choose what to do next
                System.out.println("\n\tWhat to do next?");
                System.out.println("\ta. Attack");
                System.out.println("\tr. Run Away!");

                String input =  in.nextLine();
                if (input.equals("a")){
                    //Random damage
                    int damageDealt = rand.nextInt(maxAttachDamage);
                    int damageTaken = rand.nextInt(maxEnemyAttachDamage);

                    enemyHealth -= damageDealt;
                    health -= damageTaken;

                    System.out.println("\t> You strike the "+enemy+" for "+damageDealt+" damage.");
                    System.out.println("\t> You get "+damageTaken+ " in retaliation!");

                    //Basically it means "game over"
                    if (health<=1) {
                        health = 1;
                        System.out.println("You have taken too much damage, you are too weak to go on!");
                    }

                }
                else if (input.equals("r")){
                    System.out.println("You run away from "+enemy+"!");
                    break;
                }
                else {
                    //Opps! pressed the wrong button
                    System.out.println("Do not panic. Choose again\n");
                }
            }

            System.out.println("--------------------------------------------------------------------");
            if (enemyHealth<=0){
                //Enemy is defeated
                System.out.println(" # "+enemy+" was defeated! #");
                System.out.println("You have "+health+" HP left.");
                System.out.println("Skeleton dropped a health potion!");
                health = health + 10;
                System.out.println("You have "+health+" HP left.");


            }

            //After defeat one enemy, let user to choose what to do next
            System.out.println("\n\tWhat to do next?");
            System.out.println("\t1. Continue fighting");
            System.out.println("\t2. Leave the dungeon");

            String input = in.nextLine();
            while (!input.equals("1") && !input.equals("2")){
                System.out.println("Choose again");
                input = in.nextLine();
            }
            if (input.equals("1")){
                //a new loop
                System.out.println("You continue on your adventure!");
            }
            else if (input.equals("2")){
                System.out.println("You exit the dungeon, successful from your adventures!");
                running =  false;// stop the game
            }

        }
        System.out.println("###################################");
        System.out.println("#      THANKS FOR PLAYING!        #");
        System.out.println("###################################");
    }
}
