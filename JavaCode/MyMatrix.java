import java.util.Scanner;

/**
 * 矩阵类，实现矩阵的加法，矩阵乘法，点乘以及转置方法
 * 其中加法和点乘方法需要有两种实现方式
 * 1.传入一个MyMatrix对象进行2个矩阵的操作
 * 2.从控制台（console）读入一个矩阵数据，再进行操作
 * 所有的数据均为int型
 * 输入数据均默认为正确数据，不需要对输入数据进行校验
 * @author Ray Liu & Qin Liu
 *
 */
public class MyMatrix {
	private int[][] data;
	
	/**
	 * 构造函数，参数为2维int数组
	 * a[i][j]是矩阵中的第i+1行，第j+1列数据
	 * @param a
	 */
	public MyMatrix(int[][] a){
		this.data = a;
	}

	public int[][] getData() {
		return data;
	}

	/**
	 * 实现矩阵加法，返回一个新的矩阵
	 * @param B
	 * @return
	 */
	public MyMatrix plus(MyMatrix B){
		if (this.data.length == 0 || B.getData().length == 0 || B.getData()[0].length == 0){
			return new MyMatrix(new int[0][0]);
		}
		int[][] C = new int[this.data.length][this.data[0].length];
		for(int i = 0; i < B.getData().length; i++){
			for (int j = 0; j < B.getData()[0].length; j++){
				C[i][j] = this.getData()[i][j] + B.getData()[i][j];
			}
		}
		return new MyMatrix(C);
	}

	
	/**
	 * 实现矩阵乘法，返回一个新的矩阵
	 * @param B
	 * @return
	 */
	public MyMatrix times(MyMatrix B){
		if (this.data.length == 0 || B.getData().length == 0 || B.getData()[0].length == 0){
			return new MyMatrix(new int[0][0]);
		}
		int[][] C = new int[this.data.length][B.getData()[0].length];
		for (int i = 0; i < this.data.length; i++)
			for (int j = 0; j < B.getData()[0].length; j++)
				for (int k = 0; k < B.getData().length; k++)
					C[i][j] += this.data[i][k] * B.getData()[k][j];
		return new MyMatrix(C);
	}
	
	/**
	 * 实现矩阵的点乘，返回一个新的矩阵
	 * @param b
	 * @return
	 */
	public MyMatrix times(int b){
		if (this.data.length == 0 || this.data[0].length == 0){
			return new MyMatrix(new int[0][0]);
		}
		int[][] C = new int[this.data.length][this.data[0].length];
		for(int i = 0; i < this.data.length; i++){
			for (int j = 0; j < this.data[0].length; j++){
				C[i][j] = this.data[i][j] * b;
			}
		}
		return new MyMatrix(C);
	}
	
	/**
	 * 实现矩阵的转置，返回一个新的矩阵
	 * @return
	 */
	public MyMatrix transpose(){
		if (this.data.length == 0 || this.data[0].length == 0){
			return new MyMatrix(new int[0][0]);
		}
		int[][] C = new int[this.data[0].length][this.data.length];
		for(int i = 0; i < this.data.length; i++){
			for (int j = 0; j < this.data[0].length; j++){
				C[j][i] = this.data[i][j];
			}
		}
		return new MyMatrix(C);
	}
	
	/**
	 * 从控制台读入矩阵数据，进行矩阵加法，读入数据格式如下：
	 * m n
	 * m * n 的数据方阵，以空格隔开
	 * example:
	 * 4 3
	 * 1 2 3 
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 返回一个新的矩阵
	 * @return
	 */
	public MyMatrix plusFromConsole(){
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int n = in.nextInt();
		if (m==0||n==0){
			return new MyMatrix(new int[0][0]);
		}
		int[][] A = new int[m][n];
		for (int i=0; i<m; i++)
			for(int j=0; j<n; j++)
				A[i][j] = in.nextInt();

		return this.plus(new MyMatrix(A));
	}
	
	/**
	 * 输入格式同上方法相同
	 * 实现矩阵的乘法
	 * 返回一个新的矩阵
	 * @return
	 */
	public MyMatrix timesFromConsole(){
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int n = in.nextInt();
		if (m==0||n==0){
			return new MyMatrix(new int[0][0]);
		}
		int[][] A = new int[m][n];
		for (int i=0; i<m; i++)
			for(int j=0; j<n; j++)
				A[i][j] = in.nextInt();

		return this.times(new MyMatrix(A));
	}
	
	/**
	 * 打印出该矩阵的数据
	 * 起始一个空行，结束一个空行
	 * 矩阵中每一行数据呈一行，数据间以空格隔开
	 * example：
	 * 
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 
	 */
	public String toString(){
		StringBuilder str = new StringBuilder(System.getProperty("line.separator"));
		for (int[] datum : this.data) {
			for (int j = 0; j < this.data[0].length; j++) {
				str.append(datum[j]);
				if (j != this.data[0].length - 1) {
					str.append(" ");
				}
			}
			str.append(System.getProperty("line.separator"));
		}
		str.append(System.getProperty("line.separator"));
		return str.toString();
	}

	public void print(){
		System.out.print(this.toString());
	}
}
