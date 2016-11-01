import java.util.Scanner;
public class Sokoban {

	static int R, C, destR, destC;
	static int starti, startj;
	static int[][] arr;
	static int [] i_offset = {0,-1,0,1};
	static int [] j_offset = {1,0,-1,0};
	static void read()throws Exception {
		Scanner sin = new Scanner(System.in);
		R = sin.nextInt();
		C = sin.nextInt();
		arr = new int[R + 2][C + 2];
		for (int i = 0; i < R + 2; i++) {
			for (int j = 0; j < C + 2; j++) {
				arr[i][j] = -1;
			}
		}
		sin.nextLine();
		for (int i = 1; i <= R; i++) {
			String tmp = sin.nextLine();
			for (int j = 1; j <= C; j++) {                
				char ch = tmp.charAt(j-1);
				switch (ch) {
				case '#':
					arr[i][j] = -1;
					break;
				case 'B':
					arr[i][j] = 44;
					starti=i;
					startj=j;
					break;
				case 'D':
					arr[i][j]=99;
					break;
				default:
					arr[i][j] = 0;
				}
			}
		}
		sin.close();
	}
	public static void main(String[] args)throws Exception {
		read();
		
		ShortestPath sp = new ShortestPath(arr, starti, startj);
		int length = sp.getPathBFS();
		
		System.out.println(length);

	}
}