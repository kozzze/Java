import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Tool {
    enum Size { SMALL, MEDIUM, LARGE }

    private String name;
    private Size size;
    private double price;

    public Tool(String name, Size size, double price) {
        this.name = name;
        this.size = size;
        this.price = price;
    }

    public String getName() { return name; }
    public Size getSize() { return size; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return name + " [" + size + "] - $" + price;
    }
}

