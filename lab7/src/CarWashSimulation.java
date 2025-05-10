import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class CarWashSimulation {
    private static final int WASHING_UNITS = 6;
    private static final int PARKING_SPOTS = 6;
    private static final int TOTAL_CARS = 20;
    private static final int SIMULATION_TIME_HOURS = 1;
    private static final int WASH_TIME_MINUTES = 80;

    private static final Semaphore washingUnits = new Semaphore(WASHING_UNITS, true);
    private static final Semaphore parkingSpots = new Semaphore(PARKING_SPOTS, true);
    private static final ExecutorService executor = Executors.newCachedThreadPool();

    private static final AtomicInteger washedCars = new AtomicInteger(0);
    private static final AtomicInteger rejectedCars = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Симуляция мойки начинается...");

        int carsPerHour = 10;
        int minutesInHour = 60;
        int carArrivalInterval = minutesInHour / carsPerHour;

        for (int i = 0; i < TOTAL_CARS; i++) {
            final int carId = i + 1;
            executor.submit(() -> handleCar(carId));
            Thread.sleep(carArrivalInterval * 100L); // ускоренная симуляция
        }

        executor.shutdown();
        executor.awaitTermination(2, TimeUnit.HOURS);
        System.out.println("Симуляция завершена.");

        System.out.println("\n--- ИТОГОВАЯ СТАТИСТИКА ---");
        System.out.println("Всего машин: " + TOTAL_CARS);
        System.out.println("Обслужено (помыто): " + washedCars.get());
        System.out.println("Уехали без мойки: " + rejectedCars.get());
    }

    private static void handleCar(int carId) {
        System.out.println("Машина #" + carId + " подъехала к мойке");

        if (!parkingSpots.tryAcquire()) {
            System.out.println("Машина #" + carId + " не нашла места на стоянке и уехала");
            rejectedCars.incrementAndGet();
            return;
        }

        System.out.println("Машина #" + carId + " заняла место на стоянке");

        try {
            washingUnits.acquire();
            System.out.println("Машина #" + carId + " начала мойку");
            parkingSpots.release();
            Thread.sleep(WASH_TIME_MINUTES * 100L);
            System.out.println("Машина #" + carId + " завершила мойку и уехала");
            washedCars.incrementAndGet();
            washingUnits.release();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}