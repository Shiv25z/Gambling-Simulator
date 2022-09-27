package com.gamblingGame;

import java.util.Random;

public class GamblingGame {

    public static final int stake = 100; // UC1 to start the stake with $100
    public static final int bet = 1; // and bet only $1
    static int newStake ;

    public static void winLoose(int r, int bet){// UC2 to check randomly if the Gambler wins or loose the bet
        if (r==bet){
            System.out.println("Gambler Wins!");

        }
        else{
            System.out.println("Gambler Loose!");

        }
    }

    public static void main(String[] args) {
        System.out.println(" Welcome to Gambling Game Simulator! ");
        Random random = new Random();
        int r = random.nextInt(2);
        winLoose(r,bet);



    }
}
