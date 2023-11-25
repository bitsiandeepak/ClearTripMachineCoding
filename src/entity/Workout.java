package entity;

import java.util.ArrayList;
import java.util.List;

public class Workout {
    private String centerName;
    private String workoutType;
    private Integer startTime;
    private Integer endTime;
    private Integer availableSlots;
    private List<Booking> bookingList;

    public String getCenterName() {
        return centerName;
    }

    public List<Booking> getBookingList() {
        return bookingList;
    }

    public void setBookingList(List<Booking> bookingList) {
        this.bookingList = bookingList;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public String getWorkoutType() {
        return workoutType;
    }

    public void setWorkoutType(String workoutType) {
        this.workoutType = workoutType;
    }

    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }

    public Integer getAvailableSlots() {
        return availableSlots;
    }

    public void setAvailableSlots(Integer availableSlots) {
        this.availableSlots = availableSlots;
    }

    public Workout(String centerName, String workoutType, Integer startTime, Integer endTime, Integer availableSlots) {
        this.centerName = centerName;
        this.workoutType = workoutType;
        this.startTime = startTime;
        this.endTime = endTime;
        this.availableSlots = availableSlots;
        bookingList = new ArrayList<>();
    }
}
