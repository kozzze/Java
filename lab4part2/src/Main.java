import controller.CarController;
import view.CarView;

public class Main {
    public static void main(String[] args) {
        CarView view = new CarView();
        CarController controller = new CarController(view);
        view.setController(controller);
        controller.loadCars();
    }
}