package q21_read_write_append_file;

import java.io.File;
import java.io.FileReader;

public class ReadFile {
  public static void main(String[] args) {

    char[] array = new char[60];
    
    try {
      // Step 1: Creates a reader using the FileReader
      FileReader input = new FileReader("E:\\Javawork\\Phase 1\\Phase-1_Practice_Project_Assisted _Practice\\Phase-1_Practice_Project_Assisted _Practice\\src\\q21_read_write_append_file\\test.txt");

      // Step 2: Reads characters
      input.read(array);
      
      System.out.println("Data in the file:");
      System.out.println(array);

      // Step 3: Closes the reader
      input.close();
    }
    catch(Exception e) {
      e.getStackTrace();
    }
  }
}