package animals;
/**
 * Dog
 */
public class Dog {

  private String name;
  private int weight;

  public Dog(String nameOfDog, int weightOfDog) {
    this.name = nameOfDog;
    this.weight = weightOfDog;
  }

  public Dog() {
  }
  
  public void bark() {
    System.out.println(
        "Bowwow, I'm " + this.name + "! My weight is " + weight + ".");
  }
  
  public int getWeight() {
    return this.weight;
  }
}