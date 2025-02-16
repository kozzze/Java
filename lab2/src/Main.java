import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Car> cars = new ArrayList<>();

        Car car1 = new InBrand("Toyota", 2020, 2.0, "Automatic", 1000, 0.1, 2);
        Car car2 = new InBrand("BMW", 2019, 3.0, "Manual", 1200, 0.2, 3);
        Car car3 = new HomeBrand("Lada", 2018, 1.6, "Manual", 800, 0.05);
        Car car4 = new HomeBrand("GAZ", 2021, 2.4, "Automatic", 900, 0.1);
        Car car5 = new InBrand("Audi", 2022, 2.5, "Automatic", 1300, 0.15, 1);
        Car car6 = new HomeBrand("UAZ", 2017, 2.2, "Manual", 850, 0.07);
        Car car7 = new InBrand("Mercedes", 2023, 4.0, "Automatic", 1500, 0.3, 3);
        Car car8 = new HomeBrand("Renault", 2016, 1.8, "Manual", 750, 0.05);
        Car car9 = new InBrand("Hyundai", 2020, 2.0, "Automatic", 1100, 0.12, 2);
        Car car10 = new HomeBrand("Chevrolet", 2015, 2.5, "Manual", 780, 0.08);
        Car car11 = new InBrand("Ford", 2018, 2.3, "Automatic", 1000, 0.1, 1);

        addUniq(cars, car1);
        addUniq(cars, car2);
        addUniq(cars, car3);
        addUniq(cars, car4);
        addUniq(cars, car5);
        addUniq(cars, car6);
        addUniq(cars, car7);
        addUniq(cars, car8);
        addUniq(cars, car9);
        addUniq(cars, car10);
        addUniq(cars, car11);

        for (Car car : cars) {
            System.out.println("Страховка - " + calculateInsurance(car));
        }
    }

        private static void addUniq(ArrayList<Car> cars, Car newCar){
            if (!cars.contains(newCar)) {
                cars.add(newCar);
            } else {
                System.out.println("Дубликат не добавлен: " + newCar.getBrand() + " " + newCar.getYear());
            }
        }

        public static double calculateInsurance(Car car) {
            if (car instanceof InBrand) {
                return ((InBrand) car).insurance();
            } else if (car instanceof HomeBrand) {
                return ((HomeBrand) car).insurance();
            }
            return 0;
        }

    }
