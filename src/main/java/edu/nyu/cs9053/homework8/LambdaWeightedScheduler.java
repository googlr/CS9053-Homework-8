package edu.nyu.cs9053.homework8;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.Collections;
import java.util.Comparator;

public class LambdaWeightedScheduler{
	private List<LambdaWeightedJob> weightedJobList;
	private static final int minStartingTime = 0;
	private static final int maxFinalTime = Integer.MAX_VALUE;

	public LambdaWeightedScheduler(List<LambdaWeightedJob> weightedJobList){
		this.weightedJobList = new ArrayList<>();
		this.weightedJobList.add( new LambdaWeightedJob(Integer.MIN_VALUE, minStartingTime, 0) );
		this.weightedJobList.addAll( weightedJobList );
		this.weightedJobList.add( new LambdaWeightedJob(maxFinalTime, maxFinalTime, 0) );

	}

	private void sortWeightedJobListByFinalTime(){
		Collections.sort( weightedJobList, new Comparator<LambdaWeightedJob>(){
        	@Override
        	public int compare(LambdaWeightedJob job1, LambdaWeightedJob job2){
        		return  job1.getFinalTime().compareTo(job2.getFinalTime());
        	}
    	});
	}

	private void traceMaxCost( int[][] traceIndex, int start, int right, List<LambdaWeightedJob> scheduleList){
		if( traceIndex[ start ][ right ] != -1 ){
			final int k = traceIndex[ start ][ right ];
			traceMaxCost( traceIndex, start, k, scheduleList);
			scheduleList.add( weightedJobList.get(k) );
			traceMaxCost( traceIndex, k, right, scheduleList);
		}
	}

	public List<LambdaWeightedJob> getScheduleList(){
		
		sortWeightedJobListByFinalTime();

		List<LambdaWeightedJob> scheduleList = new ArrayList<>();
		final int weightedJobListSize = weightedJobList.size();

		int maxCost[][] = new int[ weightedJobListSize ][ weightedJobListSize ];
		int traceIndex[][] = new int[ weightedJobListSize ][ weightedJobListSize ];
		for(int i=0; i<weightedJobListSize; i++){
			for(int j=0; j<weightedJobListSize; j++){
				maxCost[i][j] = 0;
				traceIndex[i][j] = -1;
			}
		}

		for(int i=weightedJobListSize-1; i>=0; i--){
			for(int j=i+1; j<=weightedJobListSize-1; j++){
				for(int k=i+1; k<j; k++){
					LambdaWeightedJob currentJob = weightedJobList.get(k);
					if( currentJob.getStartingTime() >= weightedJobList.get(i).getFinalTime()
						&& currentJob.getFinalTime() <= weightedJobList.get(j).getStartingTime()){
						final int tmp = maxCost[i][k] + maxCost[k][j] + currentJob.getCost();
						if( maxCost[i][j] < tmp ){
							maxCost[i][j] = tmp;
							traceIndex[i][j] = k;
						}
					}
				}
			}
		}

		traceMaxCost( traceIndex, 0, weightedJobListSize-1, scheduleList);
		
		return scheduleList;
	}
}