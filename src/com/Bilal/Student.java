package com.Bilal;

public class Student {
    private int ID;
    private String firstName;
    private String lastName;
    private int age;
    private String lvlOfStudy;
    private String email;
    private static int Counter = 0;
    private  static int lastId = 0;

    //creating
    public Student(String firstName, String lastName, int age, String lvlOfStudy, String email){
        this.ID = ++lastId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.lvlOfStudy = lvlOfStudy;
        this.email = email;
        Counter++;
    }


    //updating
    public Student(int ID, String firstName, String lastName, int age, String lvlOfStudy, String email){
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.lvlOfStudy = lvlOfStudy;
        this.email = email;
    }


    //setters & getters
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLvlOfStudy() {
        return lvlOfStudy;
    }

    public void setLvlOfStudy(String lvlOfStudy) {
        this.lvlOfStudy = lvlOfStudy;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static String getCounter() {
        return String.valueOf(Counter);
    }

    public static void decrementCounter(){
        --Counter;
    }

    @Override
    public String toString() {
        return "ID: " + ID +"\n"+
                "First Name: " + firstName + "\n" +
                "Last Name: " + lastName + "\n" +
                "Age:" + age + "\n"+
                "Level Of Study: " + lvlOfStudy + "\n" +
                "Email: " + email + "\n\n";
    }
}
