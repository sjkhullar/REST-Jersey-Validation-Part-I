package org.learn.model;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name = "student")
public class Student {

    @DecimalMin(value = "15", message = "Student shall be minimum of age 15 yr")
    @DecimalMax(value = "30", message = "Student can not have age more than 30 yr")
    private int age;

    @Size(min = 1, max = 25, message = "The length of firstName should be between 1 to 25")
    private String firstName;

    @Size(min = 1, max = 25, message = "The length of firstName should be between 1 to 25")
    private String lastName;

    @Pattern(message = "Invalid Email Address->" +
            "Valid emails:user@gmail.com or my.user@domain.com etc.",
            regexp = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    private String email;


    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Student() {

    }

    public Student(int age, String firstName, String lastName, String email) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String toString() {
        return String.format("firstName : %s, lastName: %s, email : %s, age: %s",
                                firstName,lastName,email,age);
    }
}