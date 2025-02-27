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

    @Override
    public void onConditioner(){
        System.out.println(getBrand() + " - кодиционер вкл");
    }
    public void offConditioner(){
        System.out.println(getBrand() + " - кодиционер выкл");
    }
    @Override
    public void start() {
        System.out.println(getBrand() + " завелась!");
    }

    @Override
    public void stop() {
        System.out.println(getBrand() + " остановилась.");
    }
}
