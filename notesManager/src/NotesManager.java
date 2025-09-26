import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class NotesManager {
    public static void main (String[] args) throws IOException {
        String  path ="src/JavaNotes.txt";
        File myNotes = new File(path);
        System.out.print("Enter your notes:-");
        FileWriter myWriter = new FileWriter(myNotes,true);
//        myWriter.write("Java is very powerful language." );

        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        myWriter.write(text);
        myWriter.close();
        scanner.close();
        System.out.println(" File writing is done");

        FileReader fr =new FileReader(myNotes);
        int i;
        for( i=fr.read();i !=-1;i=fr.read())
        System.out.print(((char)i));
        fr.close();





    }
}
