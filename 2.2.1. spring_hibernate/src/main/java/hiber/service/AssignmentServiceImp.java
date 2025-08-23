package hiber.service;

import hiber.model.User;
import hiber.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AssignmentServiceImp implements AssignmentService {

    @Autowired
    private UserService userService;

    @Autowired
    private CarService carService;

    @Transactional
    @Override
    public void assignCarsToUsers() {
        List<User> users = userService.listUsers();
        List<Car> cars = carService.listCars();

        for (int i = 0; i < Math.min(users.size(), cars.size()); i++) {
            userService.assignCarToUser(users.get(i), cars.get(i));
        }
    }
}
