
public class Player {
	private int player_id;
	private int xPos;
	private int yPos;
	private int rows;
	private int columns;
	Player(int id, int x, int y, int rows, int columns){
		this.player_id=id;
		this.xPos=x;
		this.yPos=y;
		this.rows=rows;
		this.columns=columns;
	
	}
	public int getX(){
		return xPos;
	}
	public int getY(){
		return yPos;
	}
	public void movePlayer(int x_dis, int y_dis){
		xPos= (((xPos+x_dis)+rows)%rows);
		yPos= (((yPos+y_dis)+ columns) %columns);
	}
	public int getId(){
		return player_id;
	}
}
