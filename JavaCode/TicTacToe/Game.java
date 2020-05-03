package cn.edu.nju.TicTacToe;
public class Game {
	public static void main(String[] args){
		Game test = new Game();
		System.out.println(test.playGame("11","C2,B3,D3,B1,B2,D2,A3,C1,B4,C4,A2,A4,C2",4));
	}

    /**
     * Game的接口方法，我们会通过该方法进行测试
     * @param gameMode 游戏模式,有四种可能，00,01,10,11
     * @param moveStr 落子序列
     * @param size 棋盘大小，size最小为3， 最大为9
     * @return 游戏结果
     * 
     * 根据需要改写方法，参数，返回结果类型不可修改
     */
    public Result playGame(String gameMode, String moveStr, int size){
    	GameChessStrategy chessStrategy;
    	GameWinStrategy_HV winStrategy;
		switch (gameMode) {
			case "00":
				chessStrategy = new GameChessStrategy();
				winStrategy = new GameWinStrategy_HVD();
				break;
			case "01":
				chessStrategy = new GameChessStrategy();
				winStrategy = new GameWinStrategy_HV();
				break;
			case "10":
				chessStrategy = new GameChessStrategy_Uzi();
				winStrategy = new GameWinStrategy_HVD();
				break;
			case "11":
				chessStrategy = new GameChessStrategy_Uzi();
				winStrategy = new GameWinStrategy_HV();
				break;
			default:
				return Result.ERROR;
		}
    	Board board = new Board(size, chessStrategy, winStrategy);

    	String[] moves = moveStr.split(",");
    	Result res = Result.GAMING;
    	for(String move: moves){
    		res = board.nextMove(move);
    		board.print(size);
    		// 游戏结束
    		if( !res.equals(Result.GAMING) )
    			break;
    	}
    	return res;
    }

}