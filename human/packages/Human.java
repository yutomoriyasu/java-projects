package packages;
public class Human {

  public String name;

  public Human() {
    this.name = "no name";
  }

  public void setName(String str) {
    this.name = str;
  }

  public void getGreetings() {
    System.out.println("Greetings");
  }
}