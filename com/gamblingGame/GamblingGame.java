package com.gamblingGame;

import java.util.Random;

public class GamblingGame {

    public static final int stake = 100; // UC1 to start the stake with $100
    public static final int bet = 1; // and bet only $1
    int newStake=stake;


    void winLoose() {// UC2 to check randomly if the Gambler wins or loose the bet
        int winStack = 0;
        int looseStack = 0;
        int winCount = 0;
        int looseCount = 0;
        Random random= new Random();
        
        while(true) {
            int gameStatus = random.nextInt(2) ;
            if (gameStatus == bet) {
                winCount++;
                winStack += bet;
                System.out.println("Gambler Won the GAME !!! Win stack : " + winStack);
            } else {
                looseCount++;
                looseStack += bet;
                System.out.println("Gambler Lost the Game! Loose stack :" + looseStack);
            }

            if(winStack == stake / 2) {

                System.out.println("Win Stack is 50% of his Stake. So, Gambler Resigning for the DAY.");
                break;
            }

            if(looseStack == stake/ 2) {

                System.out.println("Gambler Lost his 50% stake so gambler resigns for the day!");
                break;
            }
        }
    }
        void monthGame() {
            int day=0;
            while (day != 20) {
                day++;
                System.out.println("Day "+day+ " Game starts!");// Beginning of the game
                winLoose();
                System.out.println();
                System.out.println("Game Ends for today!");// End of the game


                if (newStake == 150) {

                    System.out.println("Gambler resigns for the day " + day + " as he wins 50% more of his stake");//UC3
                    System.out.println("Day: " + day + " Won: $50");// UC4 shows win of the day
                    System.out.println();
                } else {

                    System.out.println("Gambler resigns for the day " + day + " as he looses 50%  of his stake");
                    System.out.println("Day: " + day + " Lost: $50");// UC4 shows win of the day
                    System.out.println();
                }

            }
        }




    public static void main(String[] args) {
        System.out.println(" Welcome to Gambling Game Simulator! ");
        GamblingGame gb = new GamblingGame();

        gb.monthGame();
        }


    }