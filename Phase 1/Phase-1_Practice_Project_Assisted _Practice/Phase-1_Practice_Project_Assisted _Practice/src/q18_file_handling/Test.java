package q18_file_handling;

import java.io.IOException; 
import java.nio.file.*; 
  
public class Test 
{ 
    public static void main(String[] args) 
    { 
        try
        { 
            Files.deleteIfExists(Paths.get("E:\\Javawork\\Phase 1\\Phase-1_Practice_Project_Assisted _Practice\\Phase-1_Practice_Project_Assisted _Practice\\src\\q18_file_handling\\testFile2.txt")); 
        } 
        catch(NoSuchFileException e) 
        { 
            System.out.println("No such file/directory exists"); 
        } 
        catch(DirectoryNotEmptyException e) 
        { 
            System.out.println("Directory is not empty."); 
        } 
        catch(IOException e) 
        { 
            System.out.println("Invalid permissions."); 
        } 
          
        System.out.println("Deletion successful."); 
    } 
}
