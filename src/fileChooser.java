import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.*;
import javax.swing.JFileChooser;

public class fileChooser {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        Scanner inFile;
        String line;
        Path Filename;
        Path target = new File(System.getProperty("user.dir")).toPath();
        target = target.resolve("src");
        int countSymbols = 0;
        int countLines = 0;
        int countWords = 0;
        String wordlist[];

        chooser.setCurrentDirectory(target.toFile());

        try
        {

            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                target = chooser.getSelectedFile().toPath();

                inFile = new Scanner(target);
                int i = 5;
                Filename = target.getName(i);
                while(inFile.hasNextLine())
                {
                    line = inFile.nextLine();
                    countLines = countLines + 1;
                    wordlist = line.split(" ");
                    countWords = wordlist.length +countWords;
                    countSymbols = line.length() + countSymbols;
                }
                System.out.println("Name: "+Filename);
                System.out.println("Lines: "+countLines);
                System.out.println("Words: "+countWords);
                System.out.println("Characters: "+countSymbols);

                inFile.close();
            }
            else
            {
                System.out.println("You did not choose a file. Quitting.");
                System.exit(0);
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File Not Found Error");
            e.printStackTrace();
        }
        catch (IOException e)
        {
            System.out.println("IOException Error");
            e.printStackTrace();
        }
    }

}