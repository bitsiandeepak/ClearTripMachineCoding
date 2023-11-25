package controller;

import entity.*;
import exception.CustomException;

import java.awt.print.Book;
import java.util.*;

public class CenterController {
    private Map<String, Center> centerMap;

    private static CenterController centerControllerobj = new CenterController();

    public Map<String, Center> getCenterMap() {
        return centerMap;
    }

    public void setCenterMap(Map<String, Center> centerMap) {
        this.centerMap = centerMap;
    }

    private CenterController() {
        this.centerMap = new HashMap<>();
        centerControllerobj = this;
    }

    public static CenterController getInstance()
    {
        return centerControllerobj;
    }

    public void addCenter(String centerName) throws CustomException {
        if(!(centerMap.get(centerName) == null))
        {
            throw new CustomException("Same centerName already exists");
        }
        centerMap.put(centerName, new Center(centerName));
    }

    public void addCenterTimings(String centreName, List<TimeSlot> timings) throws CustomException {
        //Todo: validate if the timings are correct.

        Center centre = centerMap.get(centreName);
        if(centre == null)
        {
            throw new CustomException("No such centre exists");
        }
        centre.setTimeSlotList(timings);
        for(TimeSlot timeSlot: timings)
        {
            for(int i=timeSlot.getStartTime();i<timeSlot.getEndTime();i++)
            {
                centre.getIsAvailable()[i] = Boolean.TRUE;
            }
        }
    }

    public void addCenterActivities(String centreName, List<String> activities) throws CustomException {
        Center centre = centerMap.get(centreName);
        if(centre == null)
        {
            throw new CustomException("No such centre exists");
        }
        Set<String> activitySet = new HashSet<>();
        for(String activity: activities)
        {
            activitySet.add(activity);
        }
        centre.setCenterActivityList(activitySet);
    }

    public void createBooking(User user, String centerName, String workoutType, Integer startTime, Integer endTime) throws CustomException {
        Center centre = centerMap.get(centerName);
        if(centre == null)
        {
            throw new CustomException("No such centre exists");
        }
        Workout workout = centre.getWorkoutList().stream().filter(workout1 -> workout1.getCenterName().equals(centerName) && workout1.getWorkoutType().equals(workoutType) &&
        workout1.getStartTime() == startTime && workout1.getEndTime() == endTime).findFirst().orElse(null);

        if(workout == null)
        {
            throw new CustomException("No such workout exists");
        }

        if(workout.getAvailableSlots() >= 0)
        {
            Booking booking = new Booking(user.getName(), workout, BookingStatus.BOOKED, startTime, endTime);
            workout.getBookingList().add(booking);
            workout.setAvailableSlots(workout.getAvailableSlots() - 1);
        }
    }
}
