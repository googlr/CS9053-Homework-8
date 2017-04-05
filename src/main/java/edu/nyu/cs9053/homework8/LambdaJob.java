package edu.nyu.cs9053.homework8;

//import java.time.LocalDateTime;

public class LambdaJob{
	private final int startingTime;
	private final int finalTime;
	public LambdaJob(int startingTime, int finalTime){
		this.startingTime = startingTime;
		this.finalTime = finalTime;
	}

	public int getStartingTime(){
		return this.startingTime;
	}

	public int getFinalTime(){
		return this.finalTime;
	}
}