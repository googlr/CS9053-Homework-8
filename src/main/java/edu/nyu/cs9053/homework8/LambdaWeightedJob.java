package edu.nyu.cs9053.homework8;

public class LambdaWeightedJob extends LambdaJob{
	private final int cost;
	
	public LambdaWeightedJob(int startingTime, int finalTime, int cost){
		super(startingTime, finalTime);
		this.cost = cost;
	} 

	@Override public int getStartingTime(){
		return super.getStartingTime();
	}

	@Override public int getFinalTime(){
		return super.getFinalTime();
	}

	public int getCost(){
		return this.cost;
	}
}