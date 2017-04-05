package edu.nyu.cs9053.homework8;

public class LambdaWeightedJob extends LambdaJob{
	private final int cost;
	
	public LambdaWeightedJob(int startingTime, int finalTime, int cost){
		super(startingTime, finalTime);
		this.cost = cost;
	} 

	@Override public Integer getStartingTime(){
		return super.getStartingTime();
	}

	@Override public Integer getFinalTime(){
		return super.getFinalTime();
	}

	public Integer getCost(){
		return this.cost;
	}
}