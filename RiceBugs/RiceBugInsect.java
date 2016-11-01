
public class RiceBugInsect {

	private int strength =0;
	private boolean alive = false;
	private char direction;
	private int xpos;
	private int ypos;
	private int startTime;
	RiceBugInsect(int xpos1, int ypos1, int startTime1, char direction1){
		ypos=xpos1;
		xpos=ypos1;
		startTime=startTime1;
		direction=direction1;
	}
	public int getStartTimeLeft(){
		return startTime;
	}
	public boolean isAlive(){
		return alive;
	}
	public void startBug(){
		alive=true;
	}
	public int isStrong(){
		return strength;
	}
	public void getStronger(){
		strength++;
	}
	public void kill(){
		alive =false;
	}
	public char getDirection(){
		return direction;
	}
	public void setPos(int x, int y){
		xpos=x;
		ypos=y;
	}
	public int getX(){
		return xpos;
	}
	public int getY(){
		return ypos;
	}
	public void setX(int x){
		xpos =x;
	}
	public void setY(int y){
		ypos =y;
	}
	
}
