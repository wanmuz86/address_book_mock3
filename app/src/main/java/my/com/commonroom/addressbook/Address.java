package my.com.commonroom.addressbook;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "address_table")
public class Address {

    @PrimaryKey(autoGenerate = true)
    int id;
    private String firstName;
    private String lastName;
    private String address1;
    private String type1;
    private String address2;
    private String type2;
    private String email;
    private String phone;
    private String cell;

    public Address(String firstName, String lastName, String address1, String type1, String address2, String type2, String email, String phone, String cell) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address1 = address1;
        this.type1 = type1;
        this.address2 = address2;
        this.type2 = type2;
        this.email = email;
        this.phone = phone;
        this.cell = cell;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress1() {
        return address1;
    }

    public String getType1() {
        return type1;
    }

    public String getAddress2() {
        return address2;
    }

    public String getType2() {
        return type2;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getCell() {
        return cell;
    }

}
