```java
import java.util.Scanner;

public class Meiern_Mia {

        public static void main(String[] args) {
            game();
        }

        //Methode für das Spiel
        public static void game() {
            int lastThrow = 0; // The lastThrow starts from zero
            boolean gameRuns = true; //Indicates whether the game continues
            boolean doublets = false; //Doublets variable
            boolean player1 = true; //Indicates whether the player1 is on the move
            int roundCounter = 1; //Start value of the round counter

            System.out.println("GAME #" + roundCounter);

            while (gameRuns) {
                int throw1 = dice(); //Both throws are assigned to the method dice
                int throw2 = dice();

                if (player1) {//Determines whether it is the turn of s1 or s2
                    System.out.println("P1: ");
                    player1 = false;
                } else {
                    System.out.println("P2: ");
                    player1 = true;
                }

                System.out.println("Diced numbers: " + throw1 + " " + throw2);

                int currentThrow; //Is compared with lastThrow
                if (throw1 < throw2) {
                    currentThrow = 10 * throw2 + throw1;
                } else if (throw1 > throw2) {
                    currentThrow = 10 * throw1 + throw2;
                } else { // Doublets!
                    currentThrow = 66 + throw1; // 66, since this is the highest possible number that can be rolled
                    // +throw1 to compare the different doubles, e.g. 66 + 3 for a triple, or 66 + 1 for a single.
                    //For example: 69 > 67 -> 3 doubles is larger than 1 doubles.
                    doublets = true;
                }
                //Checks doubles (/doublets) whether true or false
                if (doublets) {
                    System.out.println("Current throw: DOUBLETS, Last Throw: " + lastThrow);
//                System.out.println("Momentaner Wurf: " + dieserWurf + ", Letzter Wurf: PASCH");
                    doublets = false;
                } else if (lastThrow > 66) {
                    System.out.println("Current throw: " + currentThrow + ", Last Throw: DOUBLETS");
                    doublets = false;
                } else {
                    System.out.println("Current throw: " + currentThrow + ", Last Throw: " + lastThrow);
                    doublets = false;
                }
                //Calculation of the game
                if (currentThrow == 21) {//MIA!/MEIER!
                    System.out.println("MEIER! --> GAME OVER, Last throw lost.");
                    gameRuns = false;
                } else if (currentThrow > lastThrow) {
                    // passt alles, Spiel geht weiter
                    System.out.println("The current throw is larger than the last throw --> GAME CONTINUES");
                    lastThrow = currentThrow; // A player has finished his throw, so the current throw in the next round is the last throw
                } else {
                    //thisThrow has NOT outbid lastThrow -> lastThrow wins
                    System.out.println("The current throw is less than (or equal to) the last throw --> GAME OVER, last throw won.");
                    gameRuns = false;
                }

                if (!gameRuns) { //--> New game
                    player1 = true;
                    lastThrow = 0; //So that the new game starts again from 0
                    System.out.println("---------------------------");//Optional inputs
                    System.out.println("New game?");
                    System.out.println("Enter Y or Yes for YES, N or No for NO.");
                    Scanner scanner = new Scanner(System.in);
                    String eingabe = scanner.nextLine();
                    System.out.println("---------------------------");
                    if (eingabe.equals("y") || eingabe.equals("Y") || eingabe.equals("Yes") || eingabe.equals("YES") || eingabe.equals("yes")) {
                        gameRuns = true;
                        System.out.println("NEW GAME!");
                        System.out.println("GAME #" + (roundCounter = roundCounter + 1));//Counts the games
                    } else if (eingabe.equals("n") || eingabe.equals("N") || eingabe.equals("No") || eingabe.equals("NO") || eingabe.equals("no")) {
                        gameRuns = false;
                        System.out.println("Thank you so much for playing!");
                        if (roundCounter == 1) {
                            System.out.println("You have played " + roundCounter + " round.");//If you played one round
                        } else {
                            System.out.println("You have played " + roundCounter + " round."); //If played more than one rounds
                        }
                    } else {//The other cases (e.g. if you didn't enter yes or no)
                        System.out.println("ERROR");
                        System.out.println("You either didn't decide or didn't answer <<Yes>> or <<No>>.");//Then you'll be prompt to enter again
                        System.out.println("---------------------------");
                        System.out.println("Please enter again if you want to continue playing.");
                        System.out.println("Y or Yes for YES, N or No for NO.");
                        scanner = new Scanner(System.in);
                        eingabe = scanner.nextLine();
                        System.out.println("---------------------------"); //Again everything, so that you can enter something again afterwards
                        if (eingabe.equals("y") || eingabe.equals("Y") || eingabe.equals("Yes") || eingabe.equals("YES") || eingabe.equals("yes")) {
                            gameRuns = true;
                            System.out.println("NEW GAME!");
                            System.out.println("GAME #" + (roundCounter = roundCounter + 1));//Round Counter continues
                        } else if (eingabe.equals("n") || eingabe.equals("N") || eingabe.equals("No") || eingabe.equals("NO") || eingabe.equals("no")) {
                            gameRuns = false;
                            System.out.println("Thank you so much for playing!");
                            if (roundCounter == 1) {
                                System.out.println("You have played " + roundCounter + " round.");//Same as above
                            } else {
                                System.out.println("You have played " + roundCounter + " round.");
                            }
                        } else {
                            System.out.println("ERROR");
                            System.out.println("You either didn't decide or didn't answer <<Yes>> or <<No>>.");
                            System.out.println("It will be finished!");
                            System.out.println("---------------------------");
                            gameRuns = false;
                        }

                    }
                }
            }
        }


        public static int dice() {
            return (int) Math.floor(Math.random() * 6) + 1; //outputs a random number for the game method
        }
    }
```

/*#################################################################################################
####################################Copyright by JakeGame##########################################
GITHUB: https://github.com/JakeGame3 ##############################################################
ABOUT ME: https://github.com/JakeGame3/AboutMe ####################################################
 */

