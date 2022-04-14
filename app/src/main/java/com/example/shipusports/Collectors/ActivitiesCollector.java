package com.example.shipusports.Collectors;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

public class ActivitiesCollector{
    public static List<Activity> activities = new ArrayList<>();

    public static void addActivities(Activity activity){
        activities.add(activity);
    }

    public static void removeActivity(Activity activity){
        activities.remove(activity);
    }

    public static void finishAllActivities(){
        for (Activity activity : activities) {
            activity.finish();
        }
        activities.clear();
    }

}
