package controller;

import entity.Admin;
import entity.Center;
import entity.User;
import entity.Workout;
import exception.CustomException;

import java.util.HashMap;
import java.util.Map;

public class AdminController {
    CenterController centerController = CenterController.getInstance();

    public void addWorkout(String centerName, String workoutType, Integer startTime, Integer endTime, Integer availableSlots) throws CustomException {
        Map<String, Center> centerMap = centerController.getCenterMap();
        Center center = centerMap.get(centerName);
        if(center == null)
        {
            throw new CustomException("No such centre exists");
        }
        if(!center.getCenterActivityList().contains(workoutType))
        {
            throw new CustomException("This workout doesn't exists in this center");
        }
        //Validate if all slots are availale
        Boolean arrAllSlotsAvailable = true;
        for(int i= startTime; i<endTime;i++)
        {
            if(center.getIsAvailable()[i] == Boolean.FALSE)
            {
                arrAllSlotsAvailable = false;
                break;
            }
        }
        if(arrAllSlotsAvailable == false)
        {
            throw new CustomException("All the slots are not available to create this workout");
        }
        Workout workout = new Workout(centerName,workoutType, startTime, endTime, availableSlots);
        Boolean[] availSlots = center.getIsAvailable();
        for(int i=startTime;i<endTime;i++)
        {
            availSlots[i] = Boolean.FALSE;
        }
        center.getWorkoutList().add(workout);
    }
}
