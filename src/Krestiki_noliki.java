class Game {
    char[][] board = new char[3][3];
    Player1 player1, player2;

    Game(Player1 player1, Player1 player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    void makeMove(int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    void printBoard() {
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell == 0 ? "." : cell);
            }
            System.out.println();
        }
    }
}

class Player1 {
    String name;
    char symbol;

    Player1(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }
}

public class Krestiki_noliki {
    public static void main(String[] args){
        Player1 player1 = new Player1("Player1", 'X');
        Player1 player2 = new Player1("Player2", 'O');
        Game game = new Game(player1, player2);

        game.makeMove(0, 0, 'X');
        game.makeMove(1, 1, 'O');
        game.printBoard();
    }
}
