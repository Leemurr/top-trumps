package com.company;
import java.util.*;
import java.lang.*;

public class weaponGame{

    private weapon playerCard;
    private weapon cpuCard;
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
    weaponGame(){}

    public void playWpnGm() {

        //new objects created in the weapon class.
        weapon shotgun = new weapon(12.4f, 85, 4.5f, 6, 75, 10, "Shotgun");
        weapon pistol = new weapon(3.2f, 25, 0.8f, 12, 70, 60, "Pistol");
        weapon smg = new weapon(5.4f, 35, 1.4f, 22, 60, 60, "SMG");
        weapon rifle = new weapon(5.2f, 50, 1.8f, 32, 80, 80, "Rifle");
        weapon sniperRifle = new weapon(6.8f, 75, 2.0f, 8, 90, 110, "Sniper Rifle");
        weapon rocketLauncher = new weapon(11.3f, 100, 6.0f, 1, 55, 100, "Rocket Launcher");

        //each object is stored into an array.
        weapon[] weaponList = new weapon[6];
        weaponList[0] = shotgun;
        weaponList[1] = pistol;
        weaponList[2] = smg;
        weaponList[3] = rifle;
        weaponList[4] = sniperRifle;
        weaponList[5] = rocketLauncher;


        //While the user wants to keep playing the game is Running
        while (isRunning) {

            //Shuffles the deck of weapons
            int n = weaponList.length;
            for (int i = 0; i < n; i++) {
                int r = i + (int) (Math.random() * (n - i));
                weapon temp = weaponList[r];
                weaponList[r] = weaponList[i];
                weaponList[i] = temp;
            }

            //new arrays to store each players hand of cards
            weapon[] playerHand = new weapon[3];
            weapon[] cpuHand = new weapon[3];

            //The cards are "dealt" 1 by 1 starting with the player.
            playerHand[0] = weaponList[0];
            playerHand[1] = weaponList[2];
            playerHand[2] = weaponList[4];
            cpuHand[0] = weaponList[1];
            cpuHand[1] = weaponList[3];
            cpuHand[2] = weaponList[5];

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
                System.out.print("\nYour Attribute: " + playerAttribute + "\nCPU Attribute: " + cpuAttribute);

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

