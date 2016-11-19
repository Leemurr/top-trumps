package com.company;
import java.util.*;
import java.lang.*;

public class carGame{

    private car playerCard;
    private car cpuCard;
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
    carGame(){}

    public void playCrGm() {

        //new objects created in the weapon class.
        car ford = new car(117, 10.7f, 108, 53, 13.6f, 115, "Ford");
        car bmw = new car(130, 8.7f, 140, 80, 21.9f, 389, "BMW");
        car audi = new car(143, 7.6f, 229, 82, 34.4f, 232, "Audi");
        car mercedes = new car(116, 10.5f, 109, 54, 14.0f, 137, "Mercedes-Benz");
        car porsche = new car(193,3.8f, 493, 67, 131.2f, 326, "Porsche");
        car astonmartin = new car(186, 4.5f, 550, 102, 71.2f, 511, "Aston Martin");

        //each object is stored into an array.
        car[] carList = new car[6];
        carList[0] = ford;
        carList[1] = bmw;
        carList[2] = audi;
        carList[3] = mercedes;
        carList[4] = porsche;
        carList[5] = astonmartin;

        //While the user wants to keep playing the game is Running
        while (isRunning) {

            //Shuffles the deck of weapons
            int n = carList.length;
            for (int i = 0; i < n; i++) {
                int r = i + (int) (Math.random() * (n - i));
                car temp = carList[r];
                carList[r] = carList[i];
                carList[i] = temp;
            }

            //new arrays to store each players hand of cards
            car[] playerHand = new car[3];
            car[] cpuHand = new car[3];

            //The cards are "dealt" 1 by 1 starting with the player.
            playerHand[0] = carList[0];
            playerHand[1] = carList[2];
            playerHand[2] = carList[4];
            cpuHand[0] = carList[1];
            cpuHand[1] = carList[3];
            cpuHand[2] = carList[5];

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