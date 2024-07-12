// Cloud Cast
// Tharul-J

import java.util.Scanner;
import java.net.URL;

public class CloudCast {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String url = sc.nextLine();
    sc.close(); 
    URL obj = new URL(url);
    System.out.println(obj);
  }
}   

