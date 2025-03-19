package model;

public class Car {
    private String brand;
    private String model;
    private int year;
    private String price;
    private String description;
    private String imagePath;

    public Car(String brand, String model, int year, String price, String description, String imagePath) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
        this.description = description;
        this.imagePath = imagePath;
    }

    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public int getYear() { return year; }
    public String getPrice() { return price; }
    public String getDescription() { return description; }
    public String getImagePath() { return imagePath; }
}