package packages;
import packages.Car;
public class SportsCar extends Car {
  public SportsCar() {
    super();
  }
  @Override
  public void accelerate() {
    if (this.batteryLevel == 0) {
      System.out.println("Sports Car Battery empty...");
      return;
    }
    System.out.println("Sports Car Accelerating...");
    this.batteryLevel -= 20;
    this.carSpeed += 20;
    if (this.carSpeed >= 80) {
      System.out.println("Sports Car Warning...");
    }
  }
}