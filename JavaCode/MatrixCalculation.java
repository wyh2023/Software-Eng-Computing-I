package edu.nju;

import java.util.Scanner;

/**
 * 实现矩阵的加法、乘法以及控制台输出
 * 其中加法和乘法需要有两种实现方式
 * 1.传入一个矩阵进行2个矩阵的操作
 * 2.从控制台（console）读入一个矩阵，再进行操作
 * 所有的数据均为int型
 * 输入数据均默认为正确数据，不需要对输入数据进行校验
 * @author Ray Liu & Qin Liu
 */
public class MatrixCalculation {
	
	/**
	 * 实现矩阵加法，返回一个新的矩阵
	 * @return result matrix = A + B
	 */
	public int[][] plus(int[][] A, int[][] B){
		int lenA = A.length;
		int[][] C;
		if(lenA==0){
			C = new int[0][0];
			return C;
		}
		int lenB = A[0].length;
		C = new int[lenA][lenB];
		for(int i=0; i<A.length; i++)
			for(int j=0; j<A[i].length; j++)
				C[i][j] = A[i][j] + B[i][j];
		return C;
	}
	
	/**
	 * 实现矩阵乘法，返回一个新的矩阵
	 * @return result matrix = A * B
	 */
	public int[][] times(int[][] A, int[][] B){
		if(A.length==0){
			return new int[0][0];
		}
		if (A[0].length != B.length)
			return null;
		int y = A.length;
		int x = B[0].length;
		int[][] C = new int[y][x];
		for (int i = 0; i < y; i++)
			for (int j = 0; j < x; j++)
				for (int k = 0; k < B.length; k++)
					C[i][j] += A[i][k] * B[k][j];
				return C;
	}
	
	/**
	 * 从控制台读入矩阵数据，进行矩阵加法，读入数据格式如下：
	 * m n
	 * m * n 的数据方阵，以空格隔开
	 * 连续读入2个矩阵数据
	 * example:
	 * 4 3
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 4 3
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 返回一个新的矩阵
	 */

	public int [][] plusFromConsole(){
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int n = in.nextInt();
		if (m==0||n==0){
			return new int[0][0];
		}
		int[][] A = new int[m][n];
		for (int i=0; i<m; i++)
			for(int j=0; j<n; j++)
				A[i][j] = in.nextInt();
		int p = in.nextInt();
		int q = in.nextInt();
		if (p==0||q==0){
			return new int[0][0];
		}
		int[][] B = new int[p][q];
		for (int i=0; i<p; i++)
			for(int j=0; j<q; j++)
				B[i][j] = in.nextInt();
		return plus(A, B);
	}

	/**
	 * 输入格式同上方法相同
	 * 实现矩阵的乘法
	 * 返回一个新的矩阵
	 */
	public int[][] timesFromConsole(){
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int n = in.nextInt();
		if (m==0||n==0){
			return new int[0][0];
		}
		int[][] A = new int[m][n];
		for (int i=0; i<m; i++)
			for(int j=0; j<n; j++)
				A[i][j] = in.nextInt();
		int p = in.nextInt();
		int q = in.nextInt();
		if (p==0||q==0){
			return new int[0][0];
		}
		int[][] B = new int[p][q];
		for (int i=0; i<p; i++)
			for(int j=0; j<q; j++)
				B[i][j] = in.nextInt();
		return times(A, B);
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
	public static void print(int[][] A){
		System.out.println();
		for (int[] ints : A) {
			for (int j = 0; j < ints.length; j++) {
				System.out.print(ints[j]);
				if (j < ints.length - 1)
					System.out.print(' ');
			}
			System.out.println();
		}
	}

	public static void main(String[] args){
		MatrixCalculation test = new MatrixCalculation();
		int[][] C = test.plusFromConsole();
		MatrixCalculation.print(C);
	}
}
