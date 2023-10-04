package hw2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {

    private Car car;
    private  Motorcycle motorcycle;

    @BeforeEach
    public void setUp() {
        car = new Car("Toyota", "Camry", 2022);
        motorcycle = new Motorcycle("Honda", "CBR", 2021);
    }

    //    - Проверить, что экземпляр объекта Car также является экземпляром транспортного средства
    //    (используя оператор instanceof).
    @Test
    void carIsInstanceOfVehicle() {
        assertThat(car).isInstanceOf(Vehicle.class);
    }

//    - Проверить, что объект Car создается с 4-мя колесами.
    @Test
    void carHasFourWheels() {
        assertThat(car.getNumWheels()).isEqualTo(4);
    }

//    - Проверить, что объект Motorcycle создается с 2-мя колесами.
    @Test
    public void motorcycleHasTwoWheels() {
        assertThat(motorcycle.getNumWheels()).isEqualTo(2);
    }

//    - Проверить, что объект Car развивает скорость 60 в режиме тестового вождения (используя метод testDrive()).
    @Test
    public void carTestDriveSpeed() {
        car.testDrive();
        assertThat(car.getSpeed()).isEqualTo(60);
    }

//    - Проверить, что объект Motorcycle развивает скорость 75 в режиме тестового вождения (используя метод testDrive()).
    @Test
    public void motorcycleTestDriveSpeed() {
        motorcycle.testDrive();
        assertThat(motorcycle.getSpeed()).isEqualTo(75);
    }

//    - Проверить, что в режиме парковки (сначала testDrive, потом park, т.е. эмуляция движения транспорта)
//    машина останавливается (speed = 0).
    @Test
    public void carStopsAfterParking() {
        car.testDrive();
        car.park();
        assertThat(car.getSpeed()).isEqualTo(0);
    }

//    - Проверить, что в режиме парковки (сначала testDrive, потом park, т.е. эмуляция движения транспорта)
//    мотоцикл останавливается (speed = 0).
    @Test
    public void motorcycleStopsAfterParking() {
        motorcycle.testDrive();
        motorcycle.park();
        assertThat(motorcycle.getSpeed()).isEqualTo(0);
    }

}