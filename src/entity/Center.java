package entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Center {
    private String centerName;
    private List<TimeSlot> timeSlotList;
    private Set<String> centerActivitySet;
    private List<Workout> workoutList;

    public List<Workout> getWorkoutList() {
        return workoutList;
    }

    public void setWorkoutList(List<Workout> workoutList) {
        this.workoutList = workoutList;
    }

    public Boolean[] getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Boolean[] isAvailable) {
        this.isAvailable = isAvailable;
    }

    Boolean[] isAvailable;

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public List<TimeSlot> getTimeSlotList() {
        return timeSlotList;
    }

    public void setTimeSlotList(List<TimeSlot> timeSlotList) {
        this.timeSlotList = timeSlotList;
    }

    public Set<String> getCenterActivityList() {
        return centerActivitySet;
    }

    public void setCenterActivityList(Set<String> centerActivityList) {
        this.centerActivitySet = centerActivityList;
    }

    public Center(String centerName) {
        this.centerName = centerName;
        timeSlotList = new ArrayList<>();
        centerActivitySet = new HashSet<>();
        isAvailable = new Boolean[24];
        workoutList = new ArrayList<>();
    }
}
