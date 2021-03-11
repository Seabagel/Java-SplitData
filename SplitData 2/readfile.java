import java.io.*;
import java.util.*;

public class readfile {
    public static void main(String[] args) throws Exception {
        // pass the path to the file as a parameter
        Scanner sc = new Scanner(new File("data.txt"));
        PrintWriter writer = new PrintWriter(new File("result.txt"), "UTF-8");

        while (sc.hasNextLine()) {
            String[] nl = sc.nextLine().split(" ");
            int index = 2;
            writer.println(nl[index]);
            System.out.println(nl[index]);
        }
        writer.close();
    }
}