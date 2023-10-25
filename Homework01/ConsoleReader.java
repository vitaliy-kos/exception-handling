import java.util.Scanner;

public class ConsoleReader {
    
    private Scanner scanner = new Scanner(System.in);

    public String getDataForCreatingUser(){

        return prompt("Введите данные пользователя, разделенные пробелом, в указанном формате\n(Фамилия Имя Отчество датаРождения номерТелефона пол):\n");

    }

    private String prompt(String message){
        System.out.print(message);
        return scanner.nextLine();
    }

}
