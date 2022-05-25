package packages;
import packages.Human;
public class American extends Human {
  public American() {
    super();
  }
  @Override
  public void getGreetings() {
    System.out.println(name + ":Hello");
  }
}