/*
Given an array arr of non-negative integers of size N, 2 players are playing a game. In each move, a player chooses an element from either end of the array, and the size of the array shrinks by one. Both players take alternate chances and the game continues until the size of the array becomes 0. Every time a player chooses an array element the array value is added to the player's score. At the need player with maximum score wins.
You have to predict whether player 1 will win the game or not. Both players will play optimally.

*/

import java.util.Scanner;

public class guessWinnerDp {

    /*
     * leetcode solution (Predict the winner)!!! Not clear
     */
    // public static int getWinner(int[] a, int i, int j, Integer[][] memo) {

    // if (i == j) {
    // return a[i];
    // }

    // if (memo[i][j] != null) {
    // return memo[i][j];
    // }

    // int p = a[i] - getWinner(a, i + 1, j, memo);
    // int q = a[j] - getWinner(a, i, j - 1, memo);

    // return memo[i][j] = Math.max(p, q);
    // }

    /*
     * Using memoized optimal game strategy do best when you do it (pick best in
     * your turn) consider worst when other's turn
     */
    public static int winner(int[] a, int i, int j, Integer[][] t) {

        if (i > j) {
            return 0;
        }

        if (i == j) {
            return a[i];
        }

        if (t[i][j] != null) {
            return t[i][j];
        }

        return t[i][j] = Math.max(a[i] + Math.min(winner(a, i + 2, j, t), winner(a, i + 1, j - 1, t)),
                a[j] + Math.min(winner(a, i, j - 2, t), winner(a, i + 1, j - 1, t)));

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int totalScore = 0;
        for (int x : a) {
            totalScore += x;
        }

        Integer[][] memo = new Integer[n][n];
        int firstScore = winner(a, 0, n - 1, memo);
        System.out.println(totalScore + " " + firstScore);
        boolean ans = firstScore >= totalScore - firstScore ? true : false;
        System.out.println(ans);
        sc.close();
    }
}
