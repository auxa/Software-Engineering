
public class Position {
	private int x_displacement;
	private int y_displacement;
	private String type;
	
	Position(int x, int y, String type){
		this.x_displacement=x;
		this.y_displacement=y;
		this.type=type;
	}
	Position(String type){
		this.x_displacement=0;
		this.y_displacement=0;
		this.type=type;
	}
	
	public boolean ifTrap(){
		if(type.equals("T")){
			return true;
		}else{
			return false;
		}
	}
	public boolean ifGold(){
		if(type.equals("G")){
			return true;
		}else{
			return false;
		}
	}
	public  boolean ifDisplacement(){
		if(type.equals("D")){
			return true;
		}else{
			return false;
		}
	}
	public int getXDis(){
		return x_displacement;
	}
	public int getYDis(){
		return y_displacement;
	}
}
