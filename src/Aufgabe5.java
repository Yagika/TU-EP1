public class Aufgabe5 {
    public static void main(String[] args) {
        char p1Selection = 'S'; //either 'R', 'P' or 'S'
        char p2Selection = 'R'; //either 'R', 'P' or 'S'
        /*if (p1Selection == 'R') {
            if (p2Selection == 'R') {
                System.out.println("Draw!");
            } else if (p2Selection == 'S') {
                System.out.println("Player 1 Wins!");
            } else { //hier gilt: ...p2Selection == 'P' und p1Selection == 'R'
                System.out.println("Player 2 Wins!");
            }
        } else {
            if ((p1Selection == 'P' && p2Selection == 'P') || (p1Selection == 'S' && p2Selection == 'S')) {
                System.out.println("Draw!");
            } else if (p1Selection == 'S' && p2Selection == 'P') {
                System.out.println("Player 1 Wins!");
            } else if (p1Selection == 'P' && p2Selection == 'R') {
                System.out.println("Player 1 Wins!");
            } else { //hier gilt: ...p1Selection == 'P' und p2Selection == 'R'
                System.out.println("Player 2 Wins!");
            }
        }*/


            if ((p1Selection == 'P' && p2Selection == 'P') || (p1Selection == 'S' && p2Selection == 'S') || (p1Selection == 'R' && p2Selection == 'R')) {
                System.out.println("Draw!");
            } else if ((p1Selection == 'S' && p2Selection == 'P')||(p1Selection == 'R' && p2Selection == 'S')||(p1Selection == 'P' && p2Selection == 'R')) {
                System.out.println("Player 1 Wins!");
            } else {
                System.out.println("Player 2 Wins!");
            }
        }
    }