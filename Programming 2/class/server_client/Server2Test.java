package multi_thread;

// Exercise 28.15 Solution: Server2Test.java
// Tests the server class.
import javax.swing.JFrame;

public class Server2Test
{
   public static void main(String[] args)
   {
      Server2 application = new Server2(); // create the server
      application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      application.runServer(); // run the server
   } // end main
} // end class Server2Test



/**************************************************************************
 * (C) Copyright 1992-2018 by Deitel & Associates, Inc. and               *
 * Prentice Hall. All Rights Reserved.                                    *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
