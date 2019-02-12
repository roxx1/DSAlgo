package algorithms.greedy;

import java.util.*;
import java.util.stream.Collectors;

public class JobScheduling {

    public static int scheduleJobsWithMaxProfit(List<Job> jobs) {

        Comparator<Job> comparator = Comparator.comparing(job -> job.getProfit());

        final List<Job> jobList = jobs.stream().sorted(comparator.reversed()).collect(Collectors.toList());

        final Job maxDelayJob = jobList.stream().max(Comparator.comparing(Job::getDelay)).get();

        int profit = 0;

        boolean[] jobArray = new boolean[jobList.size()];

        System.out.println(maxDelayJob.getDelay());

        for (int i = 0; i < maxDelayJob.getDelay(); i++) {

            final Job job = jobList.get(i);
            final Integer delay = job.getDelay();

            System.out.println("delay => " + delay);
            for (int j = delay - 1; j >= 0; j--) {
                if (!jobArray[j]) {
                    jobArray[j] = true;
                    System.out.println("j => " + j);
                    profit += job.getProfit();
                    System.out.println("max profit => " + job.getProfit());
                    break;
                }
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        final Job j1 = new Job(15, 7);
        final Job j2 = new Job(20, 2);
        final Job j3 = new Job(30, 5);
        final Job j4 = new Job(18, 3);
        final Job j5 = new Job(18, 4);
        final Job j6 = new Job(10, 5);
        final Job j7 = new Job(23, 2);
        final Job j8 = new Job(16, 7);
        final Job j9 = new Job(25, 3);

        final List<Job> jobList = Arrays.asList(j1, j2, j3, j4, j5, j6, j7, j8, j9);

        final int maxProfit = scheduleJobsWithMaxProfit(jobList);

        System.out.println(maxProfit);

    }

}


class Job {
    private Integer profit;
    private Integer delay;

    public Job(Integer profit, Integer delay) {
        this.profit = profit;
        this.delay = delay;
    }

    public Job() {
    }

    public Integer getProfit() {
        return profit;
    }

    public void setProfit(Integer profit) {
        this.profit = profit;
    }

    public Integer getDelay() {
        return delay;
    }

    public void setDelay(Integer delay) {
        this.delay = delay;
    }
}
