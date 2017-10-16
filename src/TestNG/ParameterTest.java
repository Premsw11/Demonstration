package TestNG;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {
   @Test
   @Parameters("myName")
   public void parameterTest(String myName) {
      System.out.println("Parameterized value is : " + myName);
   }
}