package edu.nyu.cs9053.homework8;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class LambdaScheduler{
	public LambdaScheduler(){
		;
	}

	public void getScheduleList(){
		List<LambdaJob> jobList = new ArrayList<>();
			jobList.add( new LambdaJob(2,4) );
			jobList.add( new LambdaJob(1,5) );
			jobList.add( new LambdaJob(7,8) );
			jobList.add( new LambdaJob(6,10) );
			jobList.add( new LambdaJob(9,13) );
			jobList.add( new LambdaJob(12,16) );
			jobList.add( new LambdaJob(15,17) );
		List<LambdaJob> scheduleList = new ArrayList<>();

		Iterator<LambdaJob> jobIterator = jobList.iterator();
		final int jobListSize = jobList.size();

		int lastFinalTime = 0;
		while( jobIterator.hasNext() ){
			final LambdaJob nextJob = jobIterator.next();
			if( nextJob.getStartingTime() >= lastFinalTime ){
				scheduleList.add( nextJob );
				lastFinalTime = nextJob.getFinalTime();
			}
		}

		Iterator<LambdaJob> scheduleIterator = scheduleList.iterator();
		while( scheduleIterator.hasNext() ){
			final LambdaJob currentJob = scheduleIterator.next();
			System.out.printf("(%d, %d)\n", currentJob.getStartingTime(), currentJob.getFinalTime() );
		}
	}
	public static void main(String[] args){
		LambdaScheduler lambdaScheduler = new LambdaScheduler();
		lambdaScheduler.getScheduleList();
	}
}