package cn.edu.nju.TicTacToe;
/**
 * 正常落子模式类，另一落子模式自行创建类并实现，应该考虑到可扩展性，当有新的落子模式出现时更易于添加
 * hint：采用接口的方式，接口与实现相分离
 * @author Xin Feng & Qiu Liu
 *
 */
public class GameChessStrategy {

	/**
	 * 落子方法，可根据需要自行调整传入参数
	 * @param cells  棋盘对应的char二维数组
	 * @param currentPlayer  当前落子的玩家
	 * @param chessPos  下棋位置的字符串表示
	 */
	public void putChess(char[][] cells, Player currentPlayer, String chessPos)
	{
		int i = chessPos.charAt(1) - '1';
		int j = chessPos.charAt(0) - 'A';
		cells[i][j] = currentPlayer == Player.X ? 'X' : 'O';
	}
}