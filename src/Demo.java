import controller.AdminController;
import controller.CenterController;
import controller.StandardUserController;
import entity.TimeSlot;
import exception.CustomException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Demo {

    public static void main(String args[]) throws CustomException {
        CenterController centerController = CenterController.getInstance();
        AdminController adminController = new AdminController();

        //AddCentre(“Koramangala”);
        centerController.addCenter("Koramangala");

        //AddCentretimings(“Koramangala”,List<Timings> timings);
        centerController.addCenterTimings("Koramangala", List.of(new TimeSlot(6,9), new TimeSlot(18,21)));

        //AddCentreActivities(“Koramangala”,List<String> activities);
        centerController.addCenterActivities("Koramangala", List.of("Weights", "Cardio", "Yoga", "Swimming"));

        //AddCentre(“Bellandur”);
        centerController.addCenter("Bellandur");

        //AddCentretimings(“Bellandur”,List<Timings> timings);
        centerController.addCenterTimings("Bellandur", List.of(new TimeSlot(7,10), new TimeSlot(19,22)));

        //AddCentreActivities(“Bellandur”,List<String> activities);
        centerController.addCenterActivities("Bellandur", List.of("Weights", "Cardio", "Yoga"));

        /*
        addWorkout(<centerName>, <worjour type>, <start time>, <end time>, <available slots>) addWorkout(“Koramangala”, “Weights”, 6, 7, 100)
addWorkout(“Koramangala”, “Cardio”, 7, 8, 150)
addWorkout(“Koramangala”, “Yoga”, 8, 9, 200)
addWorkout(“Bellandur”, “Weights”, 18, 19, 100) // this should not be allowed because of time addWorkout(“Bellandur”, “Swimming”, 19, 20, 100) // not allowed because of workout type addWorkout(“Bellandur”, “Cardio”, 19, 20, 20)
addWorkout(“Bellandur”, “Weights”, 20, 21, 100)
addWorkout(“Bellandur”, “Weights”, 21, 22, 100)

         */
        adminController.addWorkout("Koramangala", "Cardio", 7, 8, 150);
        adminController.addWorkout("Koramangala", "Yoga", 8, 9, 200);
        adminController.addWorkout("Bellandur", "Weights", 18, 19, 100);
//        adminController.addWorkout("Bellandur", "Swimming", 20, 21, 100);
        adminController.addWorkout("Bellandur", "Weights", 21, 22, 100);

        StandardUserController standardUserController = new StandardUserController(new ArrayList<>());

        standardUserController.addUser("Vaibhav");

        standardUserController.createBooking("Vaibhav", "Koramangala", "Cardio", 7, 8);
    }
}
