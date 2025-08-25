package web.Service;

import web.model.Car;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private final List<Car> cars;

    public CarServiceImpl() {
        cars = new ArrayList<>();
        cars.add(new Car("Toyota Camry", "Black", 2020));
        cars.add(new Car("Honda Civic", "White", 2019));
        cars.add(new Car("BMW X5", "Blue", 2021));
        cars.add(new Car("Mercedes E-Class", "Silver", 2018));
        cars.add(new Car("Audi A4", "Red", 2022));
    }

    @Override
    public List<Car> getCars(int count) {
        if (count >= 5) {
            return cars;
        }
        return cars.subList(0, count);
    }
}