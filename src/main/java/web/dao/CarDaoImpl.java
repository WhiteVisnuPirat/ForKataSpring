package web.dao;

import web.model.Car;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDaoImpl implements CarDao {

    private final List<Car> cars;

    public CarDaoImpl() {
        cars = new ArrayList<>();
        cars.add(new Car("Toyota Camry", "Black", 2020));
        cars.add(new Car("Honda Civic", "White", 2019));
        cars.add(new Car("BMW X5", "Blue", 2021));
        cars.add(new Car("Mercedes E-Class", "Silver", 2018));
        cars.add(new Car("Audi A4", "Red", 2022));
    }

    @Override
    public List<Car> getAllCars() {
        return new ArrayList<>(cars);
    }

    @Override
    public List<Car> getCars(int count) {
        return cars.subList(0, Math.min(count, cars.size()));
    }
}