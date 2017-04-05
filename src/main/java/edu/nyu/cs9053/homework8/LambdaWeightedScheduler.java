package edu.nyu.cs9053.homework8;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class LambdaWeightedScheduler{
	private final List<LambdaWeightedJob> jobList;
	private static final int minStartingTime = 0;
	private static final int maxFinalTime = Integer.MAX_VALUE;
	public LambdaWeightedScheduler(List<LambdaWeightedJob> jobList){
		this.jobList.add( new LambdaWeightedJob(Integer.MIN_VALUE, minStartingTime) );
		this.jobList.addAll( jobList );
		this.jobList.add( new LambdaWeightedJob(maxFinalTime, maxFinalTime) );

	}

	public List<LambdaWeightedJob> getScheduleList(){
		List<LambdaJob> jobList = new ArrayList<>();
				jobList.add( new LambdaJob(0,0) );

			jobList.add( new LambdaJob(2,4) );
			jobList.add( new LambdaJob(1,5) );
			jobList.add( new LambdaJob(7,8) );
			jobList.add( new LambdaJob(6,10) );
			jobList.add( new LambdaJob(9,13) );
			jobList.add( new LambdaJob(12,16) );
			jobList.add( new LambdaJob(15,17) );
		List<LambdaJob> scheduleList = new ArrayList<>();
		final int jobListSize = jobList.size() -1;
		jobList.add( new LambdaJob(1000000,1000001) );

		int c[][] = new int[jobListSize + 2][jobListSize + 2];
		int p[][] = new int[jobListSize + 2][jobListSize + 2];
		for(int i=0; i<jobListSize+2; i++){
			for(int j=0; j<jobListSize+2; j++){
				c[i][j] = 0;
				p[i][j] = -1;
			}
		}

		for(int i=jobListSize+1; i>=0; i--){
			for(int j=i+1; j<=jobListSize + 1; j++){
				for(int k=i+1; k<j; k++){
					if( jobList.get(k).getStartingTime() >= jobList.get(i).getFinalTime()
						&& jobList.get(k).getFinalTime() <= jobList.get(j).getStartingTime()){
						final int tmp = c[i][k] + c[k][j] + 1;
						if( c[i][j] < tmp ){
							c[i][j] = tmp;
							p[i][j] = k;
						}
					}
				}
			}
		}

		for(int i=0; i<jobListSize+2; i++){
			for(int j=0; j<jobListSize+2; j++){
				System.out.print(c[i][j] + " ");
			}
			System.out.print("\n");
		}		
		System.out.println("Max is " + c[0][jobListSize + 1]);
	}
}