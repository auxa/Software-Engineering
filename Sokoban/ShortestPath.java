import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ShortestPath {

	public static class Position {
		public int x;
		public int y;
		public Position parent;

		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public Position(int x, int y, Position predecessor) {
			this(x, y);
			this.parent = predecessor;
		}
	}

	private int[][] board;

	private Position[] shortestPath;

	private Stack<Position> shortPath;

	private Position start;

	public ShortestPath(int[][] matrix, int starti, int startj) {
		this.board = matrix;
		this.start = new Position(starti, startj);
	}

	public int getPathBFS() {
		shortPath = new Stack<Position>();
		shortestPath = null;
		Queue<Position> q = new LinkedList<Position>();
		q.add(start);

		LinkedList<Position> parents = new LinkedList<Position>();


		if (start == null) {
			return -1;
		}
		moveThere(start);
		while (!q.isEmpty()) {
			Position pos = q.poll();
			parents.add(pos);

			if (!endFound(pos)) {
				Position nextPos = new Position(pos.x + 1, pos.y, pos);
				if (validMove(nextPos)) {
					q.add(nextPos);
					moveThere(nextPos);
				}

				nextPos = new Position(pos.x, pos.y + 1, pos);
				if (validMove(nextPos)) {
					q.add(nextPos);
					moveThere(nextPos);
				}

				nextPos = new Position(pos.x - 1, pos.y, pos);
				if (validMove(nextPos)) {
					q.add(nextPos);
					moveThere(nextPos);
				}

				nextPos = new Position(pos.x, pos.y - 1, pos);
				if (validMove(nextPos)) {
					q.add(nextPos);
					moveThere(nextPos);
				}
			} else {
				break;
			}
		}

		Position coord = parents.getLast();
		if (coord != null) {
			do {
				shortPath.push(coord);
				coord = coord.parent;
			} while (coord != null);

			shortestPath = new Position[shortPath.size()];
			int i = 0;
			while (!shortPath.isEmpty()) {
				shortestPath[i] = shortPath.pop();
				i++;
			}

		}
		return shortestPath.length-1;
	}


	private boolean validMove(Position position) {
		return (board[position.x][position.y] !=-1 && (board[position.x][position.y] == 0 ||( endFound(position) || spaceForMan(position))));
	}
	
	private boolean endFound(Position position) {
		if(board[position.x][position.y] == 99){
			return true;
		}
		else{
			return false;
		}
	}

	private void moveThere(Position position) {
		if (board[position.x][position.y] == 0) {
			board[position.x][position.y] = 2;
		}
	}
	private boolean spaceForMan(Position pos){
		if(board[pos.x-1][pos.y] == -1 && board[pos.x+1][pos.y]==-1 && (board[pos.x][pos.y+1]==-1 || board[pos.x][pos.y-1]==-1)){
			return false;
		}else if((board[pos.x-1][pos.y] == -1 || board[pos.x+1][pos.y]==-1) && board[pos.x][pos.y+1]==-1 && board[pos.x][pos.y-1]==-1){
			return false;
		}else if(howManySpaceFree(pos)<2){
			return false;
		}
		else{
			return true;
		}
	}
	public int howManySpaceFree(Position pos){
		int count =4;
		if(board[pos.x-1][pos.y] == -1){
			count--;
		}
		if(board[pos.x+1][pos.y] == -1){
			count--;
		}
		if(board[pos.x][pos.y-1] == -1){
			count--;
		}
		if(board[pos.x][pos.y+1] == -1){
			count--;
		}
		return count;
	}


}