package ru.job4j.poly;

public class Bus implements Transport {
    private boolean hasToGo = false;

    public void drive() {
        if (hasToGo) {
            boolean driveBus = true;
        }
    }

    public void passengers(int passengers) {
        if (passengers > 0) {
            hasToGo = true;
        }
    }

    public int refuel(int fuelCount) {
        int price = (100 - fuelCount) * 50;
        return price;
    }
}
