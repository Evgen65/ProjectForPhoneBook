package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString

public class Contacts {
    String name;
    String lastName;
    String phoneNumber;
    String contEmail;
    String address;
    String description;

    public void setName(String name) {
        this.name = name;
    }
    public Contacts withName(String name){
       this.name=name;
       return this;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Contacts withLastName(String lastName){
        this.lastName = lastName;
        return this;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public Contacts withPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
        return this;
    }


    public void setContEmail(String contEmail) {
        this.contEmail = contEmail;
    }
    public Contacts withContEmail(String contEmail) {
        this.contEmail = contEmail;
        return this;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public Contacts withAddress(String address) {
        this.address = address;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public Contacts withDescription(String description) {
        this.description = description;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getContEmail() {
        return contEmail;
    }

    public String getAddress() {
        return address;
    }

    public String getDescription() {
        return description;
    }
}
