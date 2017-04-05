# Class Hirarchy
- `class` LambdaJob
	- `class` LambdaWeightedJob
- `Interface` Scheduler
	- `Abstract class` AbstractScheduler
		- `class` LambdaScheduler
		- `class` LambdaWeightedScheduler

# Task 1
Check

# Task 2
Algorithm: `Greedy Algorithm`, sort the job list by the final time. Then every time choose the compatible job that has minimum final time.

# Task 3
Algorithm: `Dynamic Programming`, sort the job list by the final time. Add job 0, whose final time is 0, and job n+1, whose starting time is Integer.MAX_VALUE. For a job list interval (i,j), denote the maximum cost of compatible set by maxCost[i][j]. While maxCost[i][j] = max{maxCost[i][k]+maxCost[k][j] + k.cost, in which k is a compatible job in (i,j).

Note that Task 2 is a special condition of Task 3 when all the jobs has the same cost.