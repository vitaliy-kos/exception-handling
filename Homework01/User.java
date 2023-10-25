public class User {

    private String firstName;
    private String lastName;
    private String middleName;
    private String dateOfBirth;
    private long phone;
    private char gender;

    public User(String lastName, String firstName, String middleName, String dateOfBirth, long phone, char gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public long getPhone() {
        return phone;
    }

    public char getGender() {
        return gender;
    }

}
