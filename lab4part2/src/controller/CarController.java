package controller;

import model.Car;
import model.Database;
import view.CarView;

import java.util.List;

public class CarController {
    private CarView view;
    private List<Car> cars;

    public CarController(CarView view) {
        this.view = view;
    }

    public void loadCars() {
        cars = Database.getInstance().getAllCars();
        view.setCarList(cars);
    }

    public void onCarSelected(String selectedCar) {
        for (Car car : cars) {
            if ((car.getBrand() + " " + car.getModel()).equals(selectedCar)) {
                view.updateCarDetails(car);
                return;
            }
        }
    }
}