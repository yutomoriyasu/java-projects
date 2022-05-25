package packages;
public class Car {

  private String maker;
  public int batteryLevel, carSpeed;

  public Car() {
    this.batteryLevel = 100;
    this.carSpeed = 0;
  }

  public void accelerate() {
    if (this.batteryLevel == 0) {
      System.out.println("Battery empty...");
      return;
    }
    System.out.println("Accelerating...");
    this.batteryLevel -= 10;
    this.carSpeed += 10;
    if (this.carSpeed >= 60) {
      System.out.println("Warning...");
    }
  }

  public void charge() {
    this.carSpeed = 0;
    System.out.println("Battery charging...");
    this.batteryLevel = 100;
  }

  public String getMaker() {
    return this.maker;
  }

  public void setMaker(String nameOfmaker) {
    this.maker = nameOfmaker;
  }

  public int getBatteryLevel() {
    return this.batteryLevel;
  }

  public int getCarSpeed() {
    return this.carSpeed;
  }
}