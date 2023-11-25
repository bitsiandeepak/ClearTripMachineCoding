package entity;

public class Booking {
    private String userName;
    private Workout workout;
    private BookingStatus bookingStatus;
    private Integer startTime;
    private Integer endTime;

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

    public Booking(String userName, Workout workout, BookingStatus bookingStatus, Integer startTime, Integer endTime) {
        this.userName = userName;
        this.workout = workout;
        this.bookingStatus = bookingStatus;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Workout getWorkout() {
        return workout;
    }

    public void setWorkout(Workout workout) {
        this.workout = workout;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public Booking(String userName, Workout workout, BookingStatus bookingStatus) {
        this.userName = userName;
        this.workout = workout;
        this.bookingStatus = bookingStatus;
    }
}
