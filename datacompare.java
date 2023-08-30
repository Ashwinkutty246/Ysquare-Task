package task3;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;

public class datacompare 
{
    public static void main(String[] args) 
    {
        HashSet<String> emailsFile1 = new HashSet<>();
        HashSet<String> emailsFile2 = new HashSet<>();

        // Read emails from file1
        try (BufferedReader reader = new BufferedReader(new FileReader("file1.txt")))
        {
            String line;
            while ((line = reader.readLine())!= null) 
            {
                emailsFile1.add(line);
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }

        // Read emails from file2
        try (BufferedReader reader = new BufferedReader(new FileReader("file2.txt"))) 
        {
            String line;
            while ((line = reader.readLine()) != null) 
            {
                emailsFile2.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Print emails present in both files
        HashSet<String> commonEmails = new HashSet<>(emailsFile1);
        commonEmails.retainAll(emailsFile2);
        System.out.println("Common emails: " + commonEmails);

        // Print emails present in file1 but not in file2
        HashSet<String> uniqueToFirst = new HashSet<>(emailsFile1);
        uniqueToFirst.removeAll(emailsFile2);
        System.out.println("Emails unique to file1: " + uniqueToFirst);

        // Print emails present in file2 but not in file1
        HashSet<String> uniqueToSecond = new HashSet<>(emailsFile2);
        uniqueToSecond.removeAll(emailsFile1);
        System.out.println("Emails unique to file2: " + uniqueToSecond);

        // Print all unique emails from both files
        HashSet<String> allUniqueEmails = new HashSet<>(emailsFile1);
        allUniqueEmails.addAll(emailsFile2);
        System.out.println("All unique emails: " + allUniqueEmails);
    }
}