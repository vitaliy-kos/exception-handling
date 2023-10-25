public class DataParser {

    private String firstName;
    private String lastName;
    private String middleName;
    private String dateOfBirth;
    private long phone;
    private char gender;

    public User parseData(String[] data) throws UserNameException, UserDateException, UserPhoneException, UserDateException {

        if (data[0].length() > 2 && data[1].length() > 2 && data[2].length() > 2 ) {
                lastName = data[0];
                firstName = data[1];
                middleName = data[2];
        } 
        else {
            throw new UserNameException("Введены некорректные фамилия, имя или отчество. Введенные значения короче 3 символов.");
        }

        try {
            checkDate(data[3]);
            dateOfBirth = data[3];
        } catch (Exception e) {
            throw new UserDateException(e.getMessage());
        }

        try {
            phone = checkPhone(data[4]);
        } catch (Exception e) {
            throw new UserPhoneException(e.getMessage());
        }

        if (data[5].charAt(0) == 'f' || data[5].charAt(0) == 'm') {
            gender = data[5].charAt(0);
        } 
        else {
            throw new UserGenderException("Невозможно получить пол пользователя из введенных данных, введенные символы должны быть \"f\" или \"m\".");
        }

        User user = new User(lastName, firstName, middleName, dateOfBirth, phone, gender);

        return user;

    }

    private long checkPhone(String str) throws UserPhoneException {
        if (str.length() == 10 || str.length() == 11) {
            
            try {
                return Long.parseLong(str);
            } 
            catch (NumberFormatException e) {
                throw new UserPhoneException("Невозможно получить телефон пользователя из введенных данных, т.к. не соответствует числовому значению.");
            }
                
        } else {
            throw new UserPhoneException("Количество символов в номере телефона ошибочно.");
        }
    }

    private void checkDate(String str) throws UserDateException {

        Integer day;
        Integer month;
        Integer year;

        String[] numbersOfDate = str.split("\\.");

        try {
            day = Integer.parseInt(numbersOfDate[0]) ;
            month = Integer.parseInt(numbersOfDate[1]);
            year = Integer.parseInt(numbersOfDate[2]);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new UserDateException("Невозможно получить дату из введенных данных. Введенные данные не соответствуют формату 00.00.0000.");
        }

        if (day < 1 || day > 31 || 
            month < 1 || month > 12 ||
            year < 1900 || year > 2023 ) {
            throw new UserDateException("Введенна не существующая дата.");
        }

    }


    
}
