package com.example.beans;

public class Student {

    // Attributes
    private String firstName;
    private String lastName;
    

    // Constructor

    public Student(){
        super();
    }

    public Student (String firstName, String lastName){
        super();
        this.firstName = firstName;
        this.lastName =lastName;
    }

    // Getter, Setter

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    @Override
    public String toString(){
        return "Student [firstName=" + firstName + ", lastName=" + lastName + "]";
    }

}
