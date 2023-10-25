
import java.io.FileWriter;
import java.io.IOException;

public class DataSaver {
    
    public Boolean writeUserToFile(User user) {

        String fileName = "Homework01/UsersFiles/" + user.getLastName() + ".txt";

        try (FileWriter writer = new FileWriter(fileName, true)) {

            writer.write( user.getLastName() + " " + 
                          user.getFirstName() + " " + 
                          user.getMiddleName()+ " " + 
                          user.getDateOfBirth()+ " " + 
                          user.getPhone()+ " " + 
                          user.getGender()+ ",\n");
            writer.flush();
            return true;

        } catch (IOException e) {

            System.out.printf("Произошла ошибка при записи файла: %s,\n Стектрейс ошибки: %s.", e.getMessage(), e.getStackTrace());

        }

        return false;

    }

}
