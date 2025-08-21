package hiber.service;

import hiber.model.User;
import hiber.model.Car;
import java.util.List;

public interface UserService {
    void add(User user);
    void addCar(Car car);
    void assignCarsToUsers();
    List<User> listUsers();
    List<Car> listCars();
}