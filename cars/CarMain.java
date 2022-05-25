import packages.Car;
import packages.SportsCar;

public class CarMain {
  public static void main(String[] args) {
    Car aCar = new Car();
    aCar.setMaker("Toyota");
    SportsCar aSportsCar = new SportsCar();
    aSportsCar.setMaker("Honda");

    for (int i = 0; i < 3; i++){
      aCar.accelerate();
    }
    aCar.charge();
    for (int i = 0; i < 8; i++){
      aCar.accelerate();
    }
    for (int i = 0; i < 4; i++){
      aSportsCar.accelerate();
    }

    System.out.println(aCar.getMaker());
    System.out.println(aCar.getBatteryLevel());
    System.out.println(aCar.getCarSpeed());
    System.out.println(aSportsCar.getMaker());
    System.out.println(aSportsCar.getBatteryLevel());
    System.out.println(aSportsCar.getCarSpeed());
  }
}
