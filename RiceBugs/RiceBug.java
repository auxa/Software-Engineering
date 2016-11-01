public class RiceBug {
	int numBugs;
	boolean[][] field;
	RiceBugInsect[] bugs;
	int[][] curPos;
	RiceBug (int numBug, int rows, int columns){
		numBugs=numBug;
		field = new boolean[rows][columns];
		bugs = new RiceBugInsect[numBug];
		curPos = new int[numBug][2];
	}

	

	public void makeAlive(int time){

		for(int i=0; i<numBugs; i++){
			if(bugs[i].isAlive()==false && bugs[i].getStartTimeLeft()==time){
				bugs[i].startBug();
				curPos[i][0]= bugs[i].getX();
				curPos[i][1]= bugs[i].getY();
			}
		}
	}
	public void killPlant(){
		for(int i=0; i< numBugs;i++){
			if(bugs[i].isAlive()==true){
				int ypos1 = bugs[i].getX();
				int xpos1 = bugs[i].getY();
				if(ypos1 <0 || xpos1 < 0 || ypos1 >field[0].length-1 || xpos1>field[0].length-1){
					return;
				}
				if(field[ypos1][xpos1]==false){
					field[ypos1][xpos1]=true;
					bugs[i].getStronger();
				}
			}
		}
	}
	public void moveBug(){
		for(int j=0; j< numBugs;j++){
			for(int k =0; k< numBugs;k++){
				if(curPos[j][0]==curPos[k][0] && curPos[j][1]==curPos[k][1] && j!=k && bugs[j].isAlive() && bugs[k].isAlive() ){
					killStronger(j,k);
				}
			}
		}
		for(int counter =0; counter<numBugs;counter++){
			if(bugs[counter].isAlive()){
				moveIt(counter);	
			}
		}
		
	}
	public void killStronger(int j, int k){
		if(bugs[j].isStrong()> bugs[k].isStrong()){
			bugs[k].kill();
		}else{
			bugs[j].kill();
		}
	}

	public void moveIt(int i){
		int temp1, temp2;

		switch(bugs[i].getDirection()){
		case 'A':
			temp1 = bugs[i].getX();
			temp2 = bugs[i].getY();
			temp1--;
			temp2--;
			curPos[i][0] = temp1;
			curPos[i][1] = temp2;

			if(temp1 <0 || temp1> field[0].length-1 || temp2<0 || temp2 > field[0].length-1){
				bugs[i].kill();
			}else{
				bugs[i].setPos(temp1, temp2);
			}
			break;
		case 'B':
			temp1 = bugs[i].getX();
			temp2 = bugs[i].getY();
			temp1--;
			//temp2--;
			curPos[i][0] = temp1;
			curPos[i][1] = temp2;

			if(temp1 <0 || temp1> field[0].length-1 || temp2<0 || temp2 > field[0].length-1){
				bugs[i].kill();
			}else{
				bugs[i].setPos(temp1, temp2);
			}
			break;
		case 'C':
			temp1 = bugs[i].getX();
			temp2 = bugs[i].getY();
			temp1--;
			temp2++;
			curPos[i][0] = temp1;
			curPos[i][1] = temp2;		
			if(temp1 <0 || temp1> field[0].length-1 || temp2<0 || temp2 > field[0].length-1){
				bugs[i].kill();
			}else{
				bugs[i].setPos(temp1, temp2);
			}			break;
		case 'D':
			temp1 = bugs[i].getX();
			temp2 = bugs[i].getY();
			//temp1--;
			temp2--;
			curPos[i][0] = temp1;
			curPos[i][1] = temp2;		
			if(temp1 <0 || temp1> field[0].length-1 || temp2<0 || temp2 > field[0].length-1){
				bugs[i].kill();
			}
			else{
				bugs[i].setPos(temp1, temp2);
			}
			break;
		case 'E':
			temp1 = bugs[i].getX();
			temp2 = bugs[i].getY();
			//temp1--;
			temp2++;
			curPos[i][0] = temp1;
			curPos[i][1] = temp2;		
			if(temp1 <0 || temp1> field[0].length-1 || temp2<0 || temp2 > field[0].length-1){
				bugs[i].kill();
			}else{
				bugs[i].setPos(temp1, temp2);
			}
			break;
		case 'F':
			temp1 = bugs[i].getX();
			temp2 = bugs[i].getY();
			temp1++;
			temp2--;
			curPos[i][0] = temp1;
			curPos[i][1] = temp2;		
			if(temp1 <0 || temp1> field[0].length-1 || temp2<0 || temp2 > field[0].length-1){
				bugs[i].kill();
			}else{
				bugs[i].setPos(temp1, temp2);
			}
			break;
		case 'G':
			temp1 = bugs[i].getX();
			temp2 = bugs[i].getY();
			temp1++;
			//temp2++;
			curPos[i][0] = temp1;
			curPos[i][1] = temp2;		
			if(temp1 <0 || temp1> field[0].length-1 || temp2<0 || temp2 > field[0].length-1){
				bugs[i].kill();
			}else{
				bugs[i].setPos(temp1, temp2);
			}
			break;
		case 'H':
			temp1 = bugs[i].getX();
			temp2 = bugs[i].getY();
			temp1++;
			temp2++;
			curPos[i][0] = temp1;
			curPos[i][1] = temp2;		
			if(temp1 <0 || temp1> field[0].length-1 || temp2<0 || temp2 > field[0].length-1){
				bugs[i].kill();
			}else{
				bugs[i].setPos(temp1, temp2);
			}
			break;
		default:
			break;
		}
	}
}