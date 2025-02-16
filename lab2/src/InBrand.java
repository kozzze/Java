
public class InBrand extends Car {

    private int packageType;

    public InBrand(String brand, int year, double volume, String transmission, double base, double color, int packageType) {
        super(brand, year, volume, transmission, base, color);
        this.packageType = packageType;
    }

    public int getPackageType() {return packageType;}

    public void setPackageType(int packageType) {this.packageType = packageType;}

    public double insurance(){
        return getBase() + 0.05 * getYear() * getVolume() * packageType;
    }

    @Override
    public String toString() {
        return super.toString() + " Комплектация - " + packageType + " Страховка - " + insurance();
    }
}