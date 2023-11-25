package controller;

import entity.Center;
import entity.StandardUser;
import entity.User;
import exception.CustomException;

import java.util.List;

public class StandardUserController {

    List<User> userList;
    CenterController centerController = CenterController.getInstance();

    public StandardUserController(List<User> userList) {
        this.userList = userList;
    }

    public void addUser(String name)
    {
        userList.add(new StandardUser(name));
    }

    public void createBooking(String name, String center, String workoutType, Integer startTime, Integer endTime) throws CustomException {
        User user = userList.stream().filter(user1 -> user1.getName() == name).findFirst().orElse(null);
        centerController.createBooking(user, center, workoutType, startTime, endTime);
    }
}
