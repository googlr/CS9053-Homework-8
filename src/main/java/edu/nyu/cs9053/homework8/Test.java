package edu.nyu.cs9053.homework8;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Test{
	public static void main(String[] args){
		List<LambdaJob> jobList = new ArrayList<>();
					jobList.add( new LambdaJob(7,8) );

			jobList.add( new LambdaJob(2,4) );
			jobList.add( new LambdaJob(1,5) );
			jobList.add( new LambdaJob(7,8) );
			jobList.add( new LambdaJob(6,10) );
			jobList.add( new LambdaJob(9,13) );
			jobList.add( new LambdaJob(12,16) );
			jobList.add( new LambdaJob(15,17) );

		final LambdaScheduler lambdaScheduler = new LambdaScheduler(jobList);
		final List<LambdaJob> scheduleList = lambdaScheduler.getScheduleList();
		Iterator<LambdaJob> scheduleIterator = scheduleList.iterator();
		while( scheduleIterator.hasNext() ){
			final LambdaJob currentJob = scheduleIterator.next();
			System.out.printf("(%d, %d)\n", currentJob.getStartingTime(), currentJob.getFinalTime() );
		}
	}
}