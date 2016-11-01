import java.util.ArrayList;
import java.util.Scanner;

public class Maze {
	static int M; //Rows
	static int N; //Columns
	static Position[][] maze;
	static ArrayList<Player> players;
	public static void main(String[] args)throws Exception {
		read();
		System.out.println(run());
	}

	public static void read(){
		Scanner sin = new Scanner(System.in);
		M = sin.nextInt(); //Rows
		N = sin.nextInt(); //Columns
		maze = new Position[M][N];
		for(int i=0;i<maze.length;i++){
			for(int j=0; j< maze[0].length;j++){
				String temp = sin.next();
				Position newPos;
				switch(temp){
				case "D":
					newPos = new Position(sin.nextInt(), sin.nextInt(), "D");
					maze[i][j]= newPos;
					break;
				case "T":
					newPos = new Position("T");
					maze[i][j]= newPos;
					break;
				case "G":
					newPos = new Position("G");
					maze[i][j]= newPos;
					break;
				default:
					break;
				}
			}

		}
		int numPlayers = sin.nextInt();
		players = new ArrayList<Player>();
		for(int i=0; i< numPlayers;i++){
			Player newPlayer = new Player(sin.nextInt(), sin.nextInt(), sin.nextInt(), M, N);
			players.add(newPlayer);

		}
		sin.close();
	}

	public static int run(){
		int ifTrapped;
		boolean notFound=true;

		while(notFound){
			for(int i=0; i< players.size(); i++){
				Player temp = players.get(i);
				ifTrapped = check(temp);

				switch(ifTrapped){
				case 0:
					return temp.getId();
					
				case -1:
					players.remove(i);
					break;
				default: 
					break;
				}
				move(temp);


			}

			
		}
		return -1;
	}
	public static void move(Player player){
		Position curPos = maze[player.getX()][player.getY()];
		player.movePlayer(curPos.getXDis(), curPos.getYDis());
	}
	
	public static int check(Player player){
		Position curPos = maze[player.getX()][player.getY()];
		if(curPos.ifDisplacement()){
			return 1;
		}
		else if(curPos.ifTrap()){
			return -1;
		}
		else if(curPos.ifGold()){
			return 0;
		}
		return 0;
	}

}

