package lk.ijse.hotelmanagementsystem_ijse.entity;

public class Customer {
    private String customer_id;
    private String name;
    private String contact;
    private String email;
    private String nic_passport;
    private String  address;


    public Customer() {
    }

    public Customer(String customer_id, String name, String contact, String email, String nic_passport, String address) {
        this.customer_id = customer_id;
        this.name = name;
        this.contact = contact;
        this.email = email;
        this.nic_passport = nic_passport;
        this.address = address;
    }

    public Customer(String name, String contact, String email, String nicPassport, String address) {
        this.name = name;
        this.contact = contact;
        this.email = email;
        this.nic_passport = nicPassport;
        this.address = address;
    }



    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNic_passport() {
        return nic_passport;
    }

    public void setNic_passport(String nic_passport) {
        this.nic_passport = nic_passport;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "address='" + address + '\'' +
                ", customer_id='" + customer_id + '\'' +
                ", name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                ", email='" + email + '\'' +
                ", nic_passport='" + nic_passport + '\'' +
                '}';
    }
}
