package cn.edu.nju.TicTacToe;

public class GameChessStrategy_Uzi extends GameChessStrategy{
    String[] uzi_x = {"", "", "", "", ""};
    String[] uzi_y = {"", "", "", "", ""};
    int num_x = 0;
    int num_y = 0;

    public void putChess(char[][] cells, Player currentPlayer, String chessPos)
    {
        if (currentPlayer == Player.X) {
            packChess(uzi_x, num_x, cells, chessPos);
            num_x++;
        } else {
            packChess(uzi_y, num_y, cells, chessPos);
            num_y++;
        }
        int i = chessPos.charAt(1) - '1';
        int j = chessPos.charAt(0) - 'A';
        cells[i][j] = currentPlayer == Player.X ? 'X' : 'O';
    }

    private void deleteChess(String[] uzi, int num, char[][] cells){
        int n, m;
        n = uzi[num % 5].charAt(1) - '1';
        m = uzi[num % 5].charAt(0) - 'A';
        cells[n][m] = '_';
    }

    private void packChess(String[] uzi, int num, char[][] cells, String chessPos){
        if(!uzi[num % 5].equals("")){
            deleteChess(uzi, num, cells);
        }
        uzi[num % 5] = chessPos;
    }
}
