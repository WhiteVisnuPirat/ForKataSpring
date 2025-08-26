package web.service;

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
    public List<Car> getCars(Integer count) {
        // Вся логика теперь в сервисе!
        if (count == null || count >= 5) {
            return new ArrayList<>(cars); // все машины
        }
        return cars.subList(0, Math.min(count, cars.size())); // ограниченное количество
    }
}
