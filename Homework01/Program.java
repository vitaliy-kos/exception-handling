public class Program {
    public static void main(String[] args) {

        ConsoleReader consoleReader = new ConsoleReader();

        while(true) {

            String[] data = consoleReader.getDataForCreatingUser().split(" ");

            switch (checkAmountData(data)) {
                case -2 -> {
                    System.out.println("-------\n  !!! Ошибка: Введено меньше данных, чем требуется. Попробуйте снова. \n-------");
                    break;
                }
                case -1 -> {
                    System.out.println("-------\n !!! Ошибка: Введено больше данных, чем требуется. Попробуйте снова. \n-------");
                    break;
                }
                case 1 -> {
                    DataParser dataParser = new DataParser();
                    
                    try {
                        User user = dataParser.parseData(data);
                        DataSaver dataSaver = new DataSaver();
                        dataSaver.writeUserToFile(user);
                        System.out.println("-------\n +++ Пользователь сохранен в файл. \n-------");
                    } catch (Exception e) {
                        System.out.println("-------\n !!! Ошибка: " + e.getMessage() + " Попробуйте снова. \n-------");

                    }
                    
                    break;
                }
                default -> {
                    break;
                }
            }

        }
        
    }

    public static int checkAmountData(String[] data) {

        if (data.length < 6) return -2;
        if (data.length > 6) return -1;

        return 1;
    }

}