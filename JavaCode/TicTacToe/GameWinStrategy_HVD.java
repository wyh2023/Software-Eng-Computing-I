package cn.edu.nju.TicTacToe;
/**
 * 横竖斜方式获胜对应的类，应该考虑到可扩展性，当有新的获胜模式出现时更易于添加
 * hint：采用接口的方式，接口与实现相分离
 * @author Xin Feng & Qiu Liu
 *
 */
public class GameWinStrategy_HVD extends GameWinStrategy_HV{
	/**
	 * 根据需要修改获胜的方法
	 * @param cells  棋盘对应的char二维数组
	 * @return  检测结果
	 */
	public Result check(char[][] cells)
	{
		char winChar = 0;
		for (char[] chars : cells) {
			for (int j = 0; j < cells.length - 2; j++) {
				if (chars[j] != '_' &&
						chars[j] == chars[j + 1] && chars[j + 1] == chars[j + 2]) {
					winChar = chars[j];
					break;
				}
			}
		}
		if(winChar == 0){
			for(int i=0; i<cells.length-2; i++){
				for(int j=0; j<cells.length; j++){
					if(cells[i][j] != '_' &&
							cells[i][j] == cells[i+1][j] && cells[i+1][j] == cells[i+2][j]){
						winChar = cells[i][j];
						break;
					}
				}
			}
		}

		if( winChar == 0){
			for(int i=0; i<cells.length-2; i++){
				for(int j=0; j<cells.length-2; j++){
					if(cells[i+1][j+1] == '_') continue;
					if((cells[i][j] == cells[i+1][j+1] && cells[i+1][j+1] == cells[i+2][j+2])
							|| (cells[i][j+2] == cells[i+1][j+1] && cells[i+1][j+1] == cells[i+2][j])){
						winChar = cells[i+1][j+1];

					}
				}
			}
		}

		switch(winChar){
			case 'X': return Result.X_WIN;
			case 'O': return Result.O_WIN;
			default: break;
		}

		for (char[] cell : cells) {
			for (int j = 0; j < cells.length; ++j) {
				if (cell[j] == '_')
					return Result.GAMING;
			}
		}

		return Result.DRAW;
	}
}