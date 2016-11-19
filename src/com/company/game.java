package com.company;
import java.util.*;
import java.lang.*;

public class game{

    public boolean intro = true;

    public void promptEnterKey(){
        System.out.println("\n\n(Press \"ENTER\" to continue...)");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    game() {
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
            }
            else if ( userIn == 2){
                intro = false;
            }
            else {
                System.out.print("That's not a valid answer! Try again\n");
            }
        }

        System.out.print("\n1. Weapons\n2. Cars\n3. Exit\n\nWhat game would you like to play?(1 - 3): ");

        Scanner input2 = new Scanner(System.in);
        int userIn2 = 0;
        userIn2 = Integer.parseInt(input2.next());


        if (userIn2 == 1) {
            System.out.print("\nYou've picked Weapons!");
            promptEnterKey();
            System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            weaponGame wpngm = new weaponGame();
            wpngm.playWpnGm();
        }
        else if (userIn2 == 3) {
            System.out.print("Exiting...");

        }
        else if ( userIn2 == 2){
            System.out.print("\nYou've picked Cars!");
            promptEnterKey();
            System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            carGame wpngm = new carGame();
            wpngm.playCrGm();
        }
        else {
            System.out.print("That's not a valid answer! Try again\n");
        }



    }
}



