import packages.Human;
import packages.Japanese;
import packages.American;
public class Hello {
  public static void main(String[] args) {
    Human mizuno = new Japanese();
    Human rod = new American();
    mizuno.setName("水野");
    rod.setName("Rod");
    mizuno.getGreetings();
    rod.getGreetings();
  }
}