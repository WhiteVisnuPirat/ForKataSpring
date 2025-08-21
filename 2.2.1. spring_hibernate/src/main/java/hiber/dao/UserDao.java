package hiber.dao;

import hiber.model.User;
import hiber.model.Car;
import java.util.List;

public interface UserDao {
   void add(User user);
   void addCar(Car car);
   List<User> listUsers();
   List<Car> listCars();
   void update(User user);
}