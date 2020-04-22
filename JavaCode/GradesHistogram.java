import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class GradesHistogram {
	/**
	 * 编写该方法对文件进行处理，并打印直方图，可添加新的方法
	 * @param fileName 处理的文件名
	 */
	public static void histogram(String fileName) throws IOException {
		Scanner in = new Scanner(Paths.get(fileName), "UTF-8");
		int num = in.nextInt();
		int[] times = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		for(int i=0; i<num; i++){
			int read_in = in.nextInt();
			if(read_in == 100){
				times[9]++;
			}else{
				read_in = read_in / 10;
				times[read_in]++;
			}
		}
		for(int i=0; i<9; i++){
			System.out.printf("%2d - %2d:", i*10, i*10+9);
			for(int j=0; j<times[i]; j++){
				System.out.print("*");
			}
			System.out.println("");
		}
		System.out.print("90 -100:");
		for(int j=0; j<times[9]; j++){
			System.out.print("*");
		}
	}
}
