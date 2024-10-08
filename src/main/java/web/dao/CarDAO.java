package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDAO {
    private static int CAR_ID;
    private List<Car> cars;

    {
        cars = new ArrayList<>();

        cars.add(new Car(++CAR_ID, "Tesla"));
        cars.add(new Car(++CAR_ID, "BMW"));
        cars.add(new Car(++CAR_ID, "Mazda"));
        cars.add(new Car(++CAR_ID, "Lada"));
        cars.add(new Car(++CAR_ID, "UAZ"));
    }

    public List<Car> getAllCars() {
        return cars;
    }

    public Car get(int id) {
        return cars.stream().filter(car -> car.getId() == id).findFirst().orElse(null);
    }

    public void save(Car car) {
        car.setId(++CAR_ID);
        cars.add(car);
    }

    public void update(int id, Car car) {
        Car old = get(id);
        old.setModel(car.getModel());
    }

    public void delete(int id) {
        cars.removeIf(car -> car.getId() == id);
    }
}
