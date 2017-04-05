package edu.nyu.cs9053.homework8;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.Collections;
import java.util.Comparator;

public class LambdaScheduler{
	private List<LambdaJob> jobList;
	private static final int minStartingTime = 0;
	private static final int maxFinalTime = Integer.MAX_VALUE;
	public LambdaScheduler(List<LambdaJob> jobList){
		this.jobList = new ArrayList<>(jobList);
	}

	private void sortJobListByFinalTime(){
		Collections.sort( jobList, new Comparator<LambdaJob>(){
        	@Override
        	public int compare(LambdaJob job1, LambdaJob job2){
        		return  job1.getFinalTime().compareTo(job2.getFinalTime());
        	}
    	});
	}

	public List<LambdaJob> getScheduleList(){

		sortJobListByFinalTime();

		List<LambdaJob> scheduleList = new ArrayList<>();

		Iterator<LambdaJob> jobIterator = jobList.iterator();
		final int jobListSize = jobList.size();

		int lastFinalTime = minStartingTime;
		while( jobIterator.hasNext() ){
			final LambdaJob currentJob = jobIterator.next();
			if( currentJob.getStartingTime() >= lastFinalTime ){
				scheduleList.add( currentJob );
				lastFinalTime = currentJob.getFinalTime();
			}
		}
		return scheduleList;
	}
}