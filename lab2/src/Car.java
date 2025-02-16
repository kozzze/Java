

public class Car {
    private String brand;
    private int year;
    private double volume;
    private String transmission;
    private double base;
    private double color;

    public Car(String brand, int year, double volume, String transmission, double base, double color) {
        this.brand = brand;
        this.year = year;
        this.volume = volume;
        this.transmission = transmission;
        this.base = base;
        this.color = color;
    }

    public String getBrand() {return brand;}
    public int getYear() {return year;}
    public double getVolume() {return volume;}
    public String getTransmission() {return transmission;}
    public double getBase() {return base;}
    public double getColor() {return color;}

    public void setBrand(String brand) {this.brand = brand;}
    public void setYear(int year) {this.year = year;}
    public void setVolume(double volume) {this.volume = volume;}
    public void setTransmission(String transmission) {this.transmission = transmission;}
    public void setBase(double base) {this.base = base;}
    public void setColor(double color) {this.color = color;}

    public void start(){
        System.out.println("Car started");
    }
    public void stop(){
        System.out.println("Car stopped");
    }
    public void onConditioner(){
        System.out.println("Car onConditioner");
    }
    public void offConditioner(){
        System.out.println("Car offConditioner");
    }

    @Override
    public String toString() {
        return "Машина:" + color + " " + brand + " " + year + " Двигатель: " + volume + " " + transmission + " " + base;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Car car = (Car) obj;
        return year == car.year &&
                Double.compare(car.volume, volume) == 0 &&
                brand.equals(car.brand) &&
                transmission.equals(car.transmission);
    }

}