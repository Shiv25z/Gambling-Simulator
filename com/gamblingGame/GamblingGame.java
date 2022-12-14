package com.gamblingGame;

import java.util.Random;
import java.util.Scanner;

public class GamblingGame {

    public static final int stake = 100; // UC1 to start the stake with $100
    public static final int bet = 1; // and bet only $1
    int newStake = stake;

    static int[] winCountArr = new int[20];
    static int[] looseCountArr = new int[20];
    static String[] day = new String[20];
    static int[] luckyDay = new int[20];
    static int[] unluckyDay = new int[20];
    static int luckyDayCount = 0;
    static int unluckyDayCount = 0;
    static int play;


    void winLoose(int i) {// UC2 to check randomly if the Gambler wins or loose the bet
        int winStack = 0;
        int looseStack = 0;
        int winCount = 0;
        int looseCount = 0;
        Random random = new Random();

        while (true) {
            int gameStatus = random.nextInt(2);
            if (gameStatus == bet) {
                winCount++;
                winStack += bet;
                System.out.println("Gambler Won the GAME !!! Win stack : " + winStack);
            } else {
                looseCount++;
                looseStack += bet;
                System.out.println("Gambler Lost the Game! Loose stack :" + looseStack);
            }
            if (winStack == stake / 2) {
                day[i] = "Won";
                System.out.println("Gambler resigns for the day " + (i + 1) + " as he wins 50% more of his stake");//UC3
                System.out.println();
                luckyDay[luckyDayCount] = i + 1;
                luckyDayCount++;
                System.out.println("Day: " + (i + 1) + " Won: " + winStack);// UC4 shows win of the day
                System.out.println();
                break;
            }
            if (looseStack == stake / 2) {
                day[i] = "Lost";
                System.out.println("Gambler resigns for the day " + (i + 1) + " as he looses 50%  of his stake");
                System.out.println();
                unluckyDay[unluckyDayCount] = i + 1;
                unluckyDayCount++;
                System.out.println("Day: " + (i + 1) + " Lost: " + looseStack);// UC4 shows win of the day
                System.out.println();
                break;
            }
            winCountArr[i] = winCount;
            looseCountArr[i] = looseCount;
        }
    }

    void monthGame() {
        for (int day = 0; day < 20; day++) {
            System.out.println("Day " + (day + 1) + " Game starts!");// Beginning of the game
            winLoose(day);
            System.out.println("Game Ends for today!");// End of the game
            System.out.println();
        }
    }

    void luckFactor() {
        System.out.println();
        System.out.print("Lucky Days: ");
        for (int i = 0; i < luckyDayCount; i++) {
            System.out.print(luckyDay[i] + ", ");
        }
        System.out.println();
        System.out.print("\nUnlucky Days: ");
        for (int i = 0; i < unluckyDayCount; i++) {
            System.out.print(unluckyDay[i] + ", ");
        }
        System.out.println();

    }

    void showWinLossCount() {

        for (int i = 0; i < 20; i++) {
            System.out.println("Day: " + (i + 1) + " Total Win count: " + (winCountArr[i] + 1));
            System.out.println("Day: " + (i + 1) + " Total Loose count: " + (looseCountArr[i] + 1));
        }
    }


    public static void main(String[] args) {
        System.out.println(" Welcome to Gambling Game Simulator! ");
        GamblingGame gb = new GamblingGame();
        Scanner sc = new Scanner(System.in);
        gb.monthGame();
        gb.showWinLossCount();
        gb.luckFactor();
        do{

            if(luckyDayCount>unluckyDayCount){
                System.out.println("You are doing great this month! Would you try next month too? ");
                System.out.println("Yes? Enter 1 or press any key to quit...");
                play = sc.nextInt();
                if(play==1) {
                    luckyDayCount = 0;
                    unluckyDayCount = 0;
                    gb.monthGame();
                    gb.showWinLossCount();
                    gb.luckFactor();
                }else {
                    break;
                }

            }else{
                System.out.println("You are out of luck and money too this month! Better try Gambling later when you have enough money");
                break;
            }

        }while(play==1);
    }



}


