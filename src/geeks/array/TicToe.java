package geeks.array;

//https://www.geeksforgeeks.org/validity-of-a-given-tic-tac-toe-board-configuration/
//https://practice.geeksforgeeks.org/problems/tic-tac-toe2412/1/#
public class TicToe {

    static int[][] win = {{0, 1, 2}, // Check first row.
            {3, 4, 5}, // Check second Row
            {6, 7, 8}, // Check third Row
            {0, 3, 6}, // Check first column
            {1, 4, 7}, // Check second Column
            {2, 5, 8}, // Check third Column
            {0, 4, 8}, // Check first Diagonal
            {2, 4, 6}};

    boolean getWin(char[] board, char c) {
        for (int i = 0; i < 8; i++)
            if (board[win[i][0]] == c &&
                    board[win[i][1]] == c &&
                    board[win[i][2]] == c)
                return true;
        return false;
    }

    boolean isValid(char[] b) {
        boolean winX = getWin(b, 'X');
        boolean winO = getWin(b, 'O');

        int countX = 0;
        int countO = 0;
        for (int i = 0; i < 9; i++) {
            if (b[i] == 'X')
                countX++;
            if (b[i] == 'O')
                countO++;
        }
        if (winX && winO)
            return false;
        if (winX)
            return countX - 1 == countO;
        if (winO)
            return countX == countO;
        return countX - 1 == countO;
    }
}
