package hiber.service;

import hiber.dao.UserDao;
import hiber.model.User;
import hiber.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;

   @Transactional
   @Override
   public void add(User user) {
      userDao.add(user);
   }

   @Transactional
   @Override
   public void addCar(Car car) {
      userDao.addCar(car);
   }

   @Transactional
   @Override
   public void assignCarsToUsers() {
      List<User> users = userDao.listUsers();
      List<Car> cars = userDao.listCars();

      for (int i = 0; i < Math.min(users.size(), cars.size()); i++) {
         User user = users.get(i);
         Car car = cars.get(i);
         user.setCar(car);
         car.setUser(user);
         userDao.update(user);
      }
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }

   @Transactional(readOnly = true)
   @Override
   public List<Car> listCars() {
      return userDao.listCars();
   }
}