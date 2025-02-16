public class HomeBrand extends Car {

    public HomeBrand(String brand, int year, double volume, String transmission, double base, double color) {
        super(brand, year, volume, transmission, base, color);
    }

    public double insurance() {
        return  getBase() + 0.03 * getVolume() * getYear();
    }

    @Override
    public String toString() {
        return super.toString() + " Страховка - " + insurance();
    }
}
