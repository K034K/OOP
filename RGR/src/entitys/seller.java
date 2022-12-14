package entitys;

public class seller extends entity {

    private String surname;
    private String address;
    private String phone;
//constructor


    public seller(int id, String name, String surname, String address, String phone, String email) {
        super(id, name);
        this.surname = surname;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    //getter and setter
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String email;

}
