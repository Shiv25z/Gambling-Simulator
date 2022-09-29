package com.gamblingGame;

import java.util.Random;

public class GamblingGame {

    public static final int stake = 100; // UC1 to start the stake with $100
    public static final int bet = 1; // and bet only $1
    int newStake=stake;

    static int[] winCountArr = new int[20];
    static int[] looseCountArr = new int[20];
    static String[] day = new String[20];



    void winLoose(int i) {// UC2 to check randomly if the Gambler wins or loose the bet
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
                day[i]= "Won";
                System.out.println("Gambler resigns for the day " + (i+1) + " as he wins 50% more of his stake");//UC3
                System.out.println();
                System.out.println("Day: " + (i+1) + " Won: "+winStack);// UC4 shows win of the day
                System.out.println();
                break;
            }
            if(looseStack == stake/ 2) {
                day[i]= "Lost";
                System.out.println("Gambler resigns for the day " + (i+1) + " as he looses 50%  of his stake");
                System.out.println();
                System.out.println("Day: " + (i+1) + " Lost: "+looseStack);// UC4 shows win of the day
                System.out.println();
                break;
            }
            winCountArr[i]= winCount;
            looseCountArr[i]=looseCount;
        }
    }
        void monthGame() {
            for(int day=0; day < 20;day++) {
                System.out.println("Day " +(day+1)+ " Game starts!");// Beginning of the game
                winLoose(day);
                System.out.println("Game Ends for today!");// End of the game
                System.out.println();
            }
            }

        void showWinLossCount(){

        for(int i=0;i<20;i++){
            System.out.println("Day: "+(i+1)+ " Total Win count: "+(winCountArr[i]+1));
            System.out.println("Day: "+(i+1)+ " Total Loose count: "+(looseCountArr[i]+1));
        }
        }




    public static void main(String[] args) {
        System.out.println(" Welcome to Gambling Game Simulator! ");
        GamblingGame gb = new GamblingGame();

        gb.monthGame();
        gb.showWinLossCount();

        }


    }