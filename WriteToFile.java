import java.io.IOException;   // Import the FileWriter class
import java.nio.file.Files;  // Import the IOException class to handle errors
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class WriteToFile {

    public WriteToFile(){

    }
    
  public void tryWriteToFile(String txt, boolean isModified){
    if(isModified){
      Path path = Paths.get("dataLogWHSW4.txt");
        String content = txt;
       
        try {
            Files.writeString(path, content, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    } else {
     Path path = Paths.get("dataLog.txt");
        String content = txt;
       
        try {
            Files.writeString(path, content, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
  }
}
