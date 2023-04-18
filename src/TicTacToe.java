import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {

        //create 2D dimensional board
        char[][] board = new char[3][3];

        // initialization
        for (int row = 0; row < board.length; row++) {
            for (int cols = 0; cols < board.length; cols++) {
                board[row][cols] = ' ';
            }
        }

        //initialize player and create boolean for gameover
        char player = 'X';
        boolean gameOver = false;

        while (!gameOver) {
            // display board
            printBoard(board);

            //Reader input
            Scanner sc = new Scanner(System.in);

            //Display what need to show
            System.out.println("Player " + player + " enter");
            int row = sc.nextInt();
            int cols = sc.nextInt();

            //Check if board is empty
            if (board[row][cols] == ' ') {

                //place the element in the board
                board[row][cols] = player;
                //After placement check if anyone has won or not
                gameOver = haveWon(board, player);

                if(gameOver){
                    System.out.println();
                    System.out.println("Player " + player + " has won");
                }else {
                    //switch player
                    if(player == 'X'){
                        player = '0';
                    }else {
                        player = 'X';
                    }
                }

            } else
                System.out.println("Invalid input. Try it again!");
        }


    }

    private static boolean haveWon(char[][] board, char player) {
        //check diagonals

        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[2][0] == player && board[1][1] == player && board[0][2] == player) {
            return true;
        }
        //check row
        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player)
                return true;
        }
        //check column
        for (int cols = 0; cols < board.length; cols++) {
            if (board[0][cols] == player && board[1][cols] == player && board[2][cols] == player)
                return true;
        }
        return false;
    }

    private static void printBoard(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int cols = 0; cols < board.length; cols++) {
                System.out.print(board[row][cols] + " | ");
            }
            System.out.println();
        }
    }
}
