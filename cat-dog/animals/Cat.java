package animals;
/**
 * Cat
 */
public class Cat {

  private String name;
  private int weight;

  public Cat(String nameOfCat, int weightOfCat) {
    this.name = nameOfCat;
    this.weight = weightOfCat;
  }

  public Cat() {
  }
  
  public void meow() {
    System.out.println(
        "Meow, I'm " + this.name + "! My weight is " + weight + ".");
  }
  
  public int getWeight() {
    return this.weight;
  }
}