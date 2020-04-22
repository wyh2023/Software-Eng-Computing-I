import java.util.Arrays;

public class Game {

    //游戏主方法playGame
    //输入为对弈双方轮番落子的位置，以英文逗号为间隔，X先走
    public Result playGame(String s){
        String[] step = s.split(",");
        Board test = new Board();
        int round = 0;
        for(String piece : step){
            String flg = (round % 2 == 0)? "X":"O";
            test.step(piece, flg);
            System.out.println(test.toString());
            round++;
            if(round > 9) break;
        }
        String res = test.check();
        Result result;
        if(res.equals("O")){
            result = Result.O_WIN;
        }else if(res.equals("X")){
            result = Result.X_WIN;
        }else{
            result = Result.DRAW;
        }
		return result;
    }

    public static void main(String[] args){
        Game game = new Game();
        Result result = game.playGame("A1,C1,A2,B2,B1,A3");
        System.out.println(result);
    }
}


class Board{
    private String[][] board = new String[][]{
                                                {"_", "_", "_"},
                                                {"_", "_", "_"},
                                                {"_", "_", "_"},};

    public static void main(String[] args){
        Board test = new Board();
        test.step("A1", "X");
        System.out.println(test.toString());
    }

    public String check(){
        for(int i=0; i<3; i++){
            String cl = this.board[i][0];
            String ca = this.board[0][i];
            if(cl.equals(this.board[i][1]) && cl.equals(this.board[i][2]) && (!cl.equals("_"))){
                return cl;
            }
            if(ca.equals(this.board[1][i]) && ca.equals(this.board[2][i]) && (!ca.equals("_"))){
                return ca;
            }
        }
        if(this.board[0][0].equals(this.board[1][1]) && this.board[0][0].equals(this.board[2][2]) && (!this.board[0][0].equals("_"))){
            return this.board[0][0];
        }
        if(this.board[0][2].equals(this.board[1][1]) && this.board[0][2].equals(this.board[2][0]) && (!this.board[0][2].equals("_"))){
            return this.board[0][2];
        }
        return "DRAW";
    }

    public void step(String s, String piece){
        char[] position = s.toCharArray();
        this.board[position[1]-49][position[0]-65] = piece;
    }

    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("  A B C");
        for(int i=0; i<3; i++){
            str.append(System.getProperty("line.separator"));
            str.append(i+1);
            for(int j=0; j<3; j++){
                str.append(" ");
                str.append(board[i][j]);
            }

        }
        return str.toString();
    }
}