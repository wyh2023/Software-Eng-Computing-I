
/**
 * pascal打印类
 */
public class PrintTriangles {

	public static void main(String[] args){
		printPascalTriangle2(3);
	}
	/**
	 * 左对齐方式
	 * 
	 * @param numRows
	 */
	public static void printPascalTriangle1(int numRows) {
		int[][] pascal = new int[numRows][];
		for(int i = 0;i < pascal.length; i++) {
			pascal[i] = new int[i+1];
		}
		for(int i=0; i<numRows; i++){
			for(int j=0; j<pascal[i].length; j++){
				if(j == 0 || j==i){
					pascal[i][j] = 1;
				}else{
					pascal[i][j] = pascal[i-1][j] + pascal[i-1][j-1];
				}
			}
		}
		for(int i=0; i<numRows; i++){
			for(int j=0; j<pascal[i].length; j++){
				System.out.print(pascal[i][j]);
				if(j<pascal[i].length-1){
					if(pascal[i][j+1]>9){
						System.out.print(" ");
					}else{
						System.out.print("  ");
					}
				}
			}
			if(i<numRows-1){
				System.out.print(System.getProperty("line.separator"));
			}
		}
	}

	/**
	 * 正常对齐方式
	 * 
	 * @param numRows
	 */
	public static void printPascalTriangle2(int numRows) {
		int[][] pascal = new int[numRows][];
		for(int i = 0;i < pascal.length; i++) {
			pascal[i] = new int[i+1];
		}
		for(int i=0; i<numRows; i++){
			for(int j=0; j<pascal[i].length; j++){
				if(j == 0 || j==i){
					pascal[i][j] = 1;
				}else{
					pascal[i][j] = pascal[i-1][j] + pascal[i-1][j-1];
				}
			}
		}
		for(int i=0; i<numRows; i++){
			for(int j=0; j<2*(numRows-1-i); j++){
				System.out.print(" ");
			}
			for(int j=0; j<pascal[i].length; j++){
				System.out.print(pascal[i][j]);
				if(j<pascal[i].length-1){
					if(pascal[i][j+1]>9){
						System.out.print("  ");
					}else{
						System.out.print("   ");
					}
				}
			}
			if(i<numRows-1){
				System.out.print(System.getProperty("line.separator"));
			}
		}
	}
}
