package greedy;

import java.util.Arrays;

public class JobSequencingProblem {

    public static void main(String[] args) {
        JobSequence[] jobSequences = {
                new JobSequence(4,70),
                new JobSequence(1,70),
                new JobSequence(1,100),
                new JobSequence(1,40)
        };

        JobSequence[] jobSequences2 = {
                new JobSequence(2,50),
                new JobSequence(2,60),
                new JobSequence(3,20),
                new JobSequence(3,30)
        };

        JobSequence[] jobSequences3 = {
                new JobSequence(2,100),
                new JobSequence(1,50),
                new JobSequence(2,10),
                new JobSequence(1,20),
                new JobSequence(3,30)
        };



        System.out.println("Total Profit is: " + getTheMaximumProfit(jobSequences));
        System.out.println();
        System.out.println("Total Profit is: " + getTheMaximumProfit(jobSequences2));
        System.out.println();
        System.out.println("Total Profit is: " + getTheMaximumProfit(jobSequences3));
    }

    private static int getTheMaximumProfit(JobSequence[] jobSequences) {

        sortTheArray(jobSequences);
        displayTheJobDetails(jobSequences);
        int countOfJobs = 0;
        int totalProfit = 0;
        for (JobSequence job : jobSequences) {
            if(countOfJobs < job.deadline){
                totalProfit += job.profit;
                countOfJobs++;
            }
        }
        return totalProfit;
    }

    private static void displayTheJobDetails(JobSequence[] jobSequences) {
        for (JobSequence job :
                jobSequences) {
            System.out.println("Deadline: " + job.deadline + ", profit: " + job.profit);
        }
    }

    private static void sortTheArray(JobSequence[] jobSequences) {
        Arrays.sort(jobSequences, (j1, j2) -> {
            if(j2.deadline < j1.deadline)
                return 1;
            else if(j2.deadline > j1.deadline)
                return -1;
            else
                return j2.profit > j1.profit ? 1:-1;
        });
    }
}

class JobSequence{
    public int deadline;
    public int profit;

    public JobSequence(int deadline, int profit) {
        this.deadline = deadline;
        this.profit = profit;
    }
}
