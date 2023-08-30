package task1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class filehandling
{

	
	public static void main(String[] args) 
	{
	

        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the path to the text file: ");
        String filePath = scanner.nextLine();
        
        System.out.print("Enter the word to replace: ");
        String word1 = scanner.nextLine();
        
        System.out.print("Enter the replacement word: ");
        String word2 = scanner.nextLine();
        
        scanner.close();
        
        findAndReplace(filePath, word1, word2);
    }
    
    public static void findAndReplace(String filePath, String word1, String word2) 
    {
        try 
        {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            StringBuilder content = new StringBuilder();
            
            String line;
            while ((line = reader.readLine()) != null) 
            {
                content.append(line).append("\n");
            }
            reader.close();
            
            String replacedContent = content.toString().replace(word1, word2);
            
            PrintWriter writer = new PrintWriter(new FileWriter(filePath));
            writer.print(replacedContent);
            writer.close();
            
            System.out.println("Replacement complete.");
        } catch (IOException e) 
        {
            System.out.println("An error occurred: " + e.getMessage());
        }
	}

}
