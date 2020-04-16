package greedy;

import java.util.ArrayList;
import java.util.Arrays;

public class ActivitySelectionProblem {

    public static void main(String[] args) {
        Activity[] activities1 = {
                new Activity(2,3),
                new Activity(1,4),
                new Activity(5,8),
                new Activity(6,10)
        };

        Activity[] activities2 = {
                new Activity(1,3),
                new Activity(2,4),
                new Activity(3,8),
                new Activity(10,11)
        };
        System.out.println(getTheNumberOfActivitiesCanBePerformed(activities2));
    }

    private static int getTheNumberOfActivitiesCanBePerformed(Activity[] activities) {
        Arrays.sort(activities, (a1,a2) -> a1.getEnd() < a2.getEnd() ? -1:1);
        for(Activity activityValue: activities){
            System.out.print("(" +activityValue.getStart() + " ->" + activityValue.getEnd() + ") ");
        }
        System.out.println();
        ArrayList<Activity> activitiesList = new ArrayList<>();
         for(int i=0; i<activities.length; i++){
             if(activitiesList.isEmpty() || activityCanBePerformed(activities[i], activitiesList))
                 activitiesList.add(activities[i]);
         }
        for(Activity activityValue: activitiesList){
            System.out.print("(" +activityValue.getStart() + " ->" + activityValue.getEnd() + ") ");
        }
        System.out.println();
        return activitiesList.size();
    }

    private static boolean activityCanBePerformed(Activity activity, ArrayList<Activity> activitiesList) {
        for(Activity activityValue: activitiesList){
            if((activity.getStart() > activityValue.getStart()) && (activity.getStart() < activityValue.getEnd()))
                return false;
            else if((activity.getEnd() > activityValue.getStart()) && (activity.getEnd() < activityValue.getEnd()))
                return false;
            else if((activity.getStart() < activityValue.getStart()) && (activity.getEnd() > activityValue.getEnd()))
                return false;
        }
        return true;
    }
}

class Activity{
    private int start;
    private int end;

    public Activity(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}
