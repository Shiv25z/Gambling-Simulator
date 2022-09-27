package com.gamblingGame;

import java.util.Random;

public class GamblingGame {

    public static final int stake = 100; // UC1 to start the stake with $100
    public static final int bet = 1; // and bet only $1
    static int newStake = stake ;

    public static void winLoose(int bet) {// UC2 to check randomly if the Gambler wins or loose the bet

        while (newStake > 50 && newStake < 150) {// UC3 to check for calculation if 50% win or loose
            int r = (int)Math.floor(Math.random()*10)%2;

            if (r == bet) {
                System.out.println("Gambler Wins!");
                newStake++;
                System.out.println("New Amount Inhand: "+newStake);
                if (newStake == 150){
                    System.out.println("Gambler resigns as he wins 50% more of his stake");//UC3
                }
                else {
                    continue;
                }

            }
            else {
                System.out.println("Gambler Loose!");
                newStake--;
                System.out.println("New Amount Inhand: "+newStake);
                if (newStake == 50){ // UC3
                    System.out.println("Gambler resigns as he looses 50%  of his stake");
                }
                else {
                    continue;
                }


                }

            }
        }

    public static void main(String[] args) {
        System.out.println(" Welcome to Gambling Game Simulator! ");
        winLoose(bet);



    }
}
