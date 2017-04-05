package edu.nyu.cs9053.homework8;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Test{
	public static void main(String[] args){

		System.out.println("Test for LambdaScheduler");

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

		System.out.println("Test for LambdaWeightedScheduler");

		List<LambdaWeightedJob> weightedJobList = new ArrayList<>();
			weightedJobList.add( new LambdaWeightedJob(7,8,1) );

			weightedJobList.add( new LambdaWeightedJob(2,4,1) );
			weightedJobList.add( new LambdaWeightedJob(1,5,1) );
			weightedJobList.add( new LambdaWeightedJob(7,8,1) );
			weightedJobList.add( new LambdaWeightedJob(6,10,1) );
			weightedJobList.add( new LambdaWeightedJob(9,13,1) );
			weightedJobList.add( new LambdaWeightedJob(12,16,1) );
			weightedJobList.add( new LambdaWeightedJob(15,17,1) );
		final LambdaWeightedScheduler lambdaWeightedScheduler = new LambdaWeightedScheduler(weightedJobList);
		final List<LambdaWeightedJob> weightedScheduleList = lambdaWeightedScheduler.getScheduleList();
		Iterator<LambdaWeightedJob> weightedScheduleIterator = weightedScheduleList.iterator();
		while( weightedScheduleIterator.hasNext() ){
			final LambdaWeightedJob currentJob = weightedScheduleIterator.next();
			System.out.printf("(%d, %d)\n", currentJob.getStartingTime(), currentJob.getFinalTime() );
		}
	}
}