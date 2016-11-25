package com.company;
import java.util.*;
import java.lang.*;

public class game{

    public boolean intro = true;
    private deck playerCard;
    private deck cpuCard;
    private float playerAttribute;
    private float cpuAttribute;
    private int plyScore = 0;
    private int cpuScore = 0;
    private int a = 0;
    public int plyChc;
    public boolean plyWin = true;
    public boolean isRunning = true;

    public void promptEnterKey(){
        System.out.println("\n\n(Press \"ENTER\" to continue...)");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    game() {
        deck[] weaponList = new deck[6];
        weaponList[0] = new weapon(-12.4f, 85, -4.5f, 6, 75, 10, "Shotgun");
        weaponList[1] = new weapon(-3.2f, 25, -0.8f, 12, 70, 60, "Pistol");
        weaponList[2] = new weapon(-5.4f, 35, -1.4f, 22, 60, 60, "SMG");
        weaponList[3] = new weapon(-5.2f, 50, -1.8f, 32, 80, 80, "Rifle");
        weaponList[4] = new weapon(-6.8f, 75, -2.0f, 8, 90, 110, "Sniper Rifle");
        weaponList[5] = new weapon(-11.3f, 100, -6.0f, 1, 55, 100, "Rocket Launcher");

        deck[] carList = new deck[6];
        carList[0] = new car(117, -10.7f, 108, 53, -13.6f, -115, "Ford");
        carList[1] = new car(130, -8.7f, 140, 80, -21.9f, -389, "BMW");
        carList[2] = new car(143, -7.6f, 229, 82, -34.4f, -232, "Audi");
        carList[3] = new car(116, -10.5f, 109, 54, -14.0f, -137, "Mercedes-Benz");
        carList[4] = new car(193, -3.8f, 493, 67, -131.2f, -326, "Porsche");
        carList[5] = new car(186, -4.5f, 550, 102, -71.2f, -511, "Aston Martin");

        deck[] myDeck = new deck[6];


        System.out.print("WELCOME TO TOP TRUMPS!!!\n");
         while (intro) {

             int userIn = 0;
             Scanner input1 = new Scanner(System.in);

             //Get input from user if it's not an integer it will ask a for a new input
             System.out.print("\n1. How To Play\n2. Play\n3. Exit\n\nWhat would you like to do?(1 - 3): ");

                 try {
                     userIn = Integer.parseInt(input1.next());
                 } catch (NumberFormatException a) {}

            if (userIn == 1) {
                System.out.print("\n○ Each player is dealt 3 cards\n○ The first player picks any attribute from their top card\n○ The second player then picks the same attribute from their card\n○ The cards are then compared against each other\n○ The winner is whoever has the highest number for that attribute\n○ You repeat until you've used all your cards\n○ The overall winner is whoever scored the most wins!");
                promptEnterKey();
            }
            else if (userIn == 3) {
                System.out.print("Exiting...");
                intro = false;
                isRunning = false;
            }
            else if ( userIn == 2){
                intro = false;
            }
            else {
                System.out.print("That's not a valid answer! Try again\n");
            }
        }


        while (isRunning) {
            boolean intro2 = true;
        while (intro2){
            System.out.print("\n1. Weapons\n2. Cars\n3. Exit\n\nWhat game would you like to play?(1 - 3): ");

            Scanner input2 = new Scanner(System.in);
            int userIn2 = 0;
            userIn2 = Integer.parseInt(input2.next());

            if (userIn2 == 1) {
                System.out.print("\nYou've picked Weapons!");
                promptEnterKey();
                myDeck = Arrays.copyOf(weaponList, weaponList.length);
                System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n");
                intro2 = false;

            } else if (userIn2 == 3) {
                System.out.print("Exiting...");
                intro2 = false;
                isRunning = false;

            } else if (userIn2 == 2) {
                System.out.print("\nYou've picked Cars!");
                promptEnterKey();
                myDeck = Arrays.copyOf(carList, carList.length);
                System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n");
                intro2 = false;

            } else {
                System.out.print("That's not a valid answer! Try again\n");
            }

        }

            //Shuffles the deck of weapons
            int n = myDeck.length;
            for (int i = 0; i < n; i++) {
                int r = i + (int) (Math.random() * (n - i));
                deck temp = myDeck[r];
                myDeck[r] = myDeck[i];
                myDeck[i] = temp;
            }

            //new arrays to store each players hand of cards
            deck[] playerHand = new deck[3];
            deck[] cpuHand = new deck[3];


            //The cards are "dealt" 1 by 1 starting with the player.
            playerHand[0] = myDeck[0];
            playerHand[1] = myDeck[2];
            playerHand[2] = myDeck[4];
            cpuHand[0] = myDeck[1];
            cpuHand[1] = myDeck[3];
            cpuHand[2] = myDeck[5];

            while (a < 3) {
                //get next card
                playerCard = playerHand[a];
                cpuCard = cpuHand[a];

                //prints out the players card
                System.out.print("\nYour card is: " + playerCard);

                //This array stores all player attributes for their chosen card.
                float[] plyAtts = new float[6];
                plyAtts[0] = playerCard.att1;
                plyAtts[1] = playerCard.att2;
                plyAtts[2] = playerCard.att3;
                plyAtts[3] = playerCard.att4;
                plyAtts[4] = playerCard.att5;
                plyAtts[5] = playerCard.att6;

                //This array stores all CPU attributes for their card.
                float[] cpuAtts = new float[6];
                cpuAtts[0] = cpuCard.att1;
                cpuAtts[1] = cpuCard.att2;
                cpuAtts[2] = cpuCard.att3;
                cpuAtts[3] = cpuCard.att4;
                cpuAtts[4] = cpuCard.att5;
                cpuAtts[5] = cpuCard.att6;

                //if player won the last hand he gets to pick the next attribute.
                if (plyWin) {
                    //Asks user for input to select attribute from list
                    System.out.print("\n\nPick an attribute(1 - 6): ");
                    Scanner input2 = new Scanner(System.in);
                    plyChc = input2.nextInt();
                }
                //if the cpu won the last hand it will randomly pick an attribute to use
                else if (!plyWin) {
                    System.out.print("\n\nThe CPU has picked an attribute.");
                    Random rand = new Random();
                    int rnd = rand.nextInt(6) + 1;
                    plyChc = rnd;
                }

                playerAttribute = plyAtts[plyChc - 1];
                cpuAttribute = cpuAtts[plyChc - 1];

                //prints out player and cpu attribute stats
                if (playerAttribute < 0 ){
                    System.out.print("\nYour Attribute: " + -playerAttribute + "\nCPU Attribute: " + -cpuAttribute);
                }
                else {
                    System.out.print("\nYour Attribute: " + playerAttribute + "\nCPU Attribute: " + cpuAttribute);
                }


                //compare attributes
                if (playerAttribute > cpuAttribute) {
                    plyScore = plyScore + 1;
                    System.out.print("\n\nPLAYER 1 WINS\nPLAYER SCORE: " + plyScore + "   CPU SCORE: " + cpuScore + "\n");
                    promptEnterKey();
                    plyWin = true;

                } else {
                    cpuScore = cpuScore + 1;
                    System.out.print("\n\nCPU WINS\nPLAYER SCORE: " + plyScore + "   CPU SCORE: " + cpuScore + "\n");
                    promptEnterKey();
                    plyWin = false;
                }

                a = a + 1;

            }
            if (plyScore > cpuScore) {
                System.out.print("\nTHE OVERALL WINNER IS PLAYER 1!\nWITH A SCORE OF " + plyScore + " TO " + cpuScore);
            } else {
                System.out.print("\nTHE OVERALL WINNER IS THE CPU!\nWITH A SCORE OF " + cpuScore + " TO " + plyScore);
            }

            //Asks user if they want to replay
            System.out.print("\n\nDo you wish to play again? Y/N: ");
            Scanner input3 = new Scanner(System.in);
            String agn = input3.next();

            //If the choice is no then the program will stop otherwise the scores are reset and it's played again.
            if (agn.equals("N") || agn.equals("n")) {
                isRunning = false;
                System.out.print("\nGAME OVER");
            } else if (agn.equals("Y") || agn.equals("y")) {
                a = 0;
                cpuScore = 0;
                plyScore = 0;
            }
        }
    }
}



