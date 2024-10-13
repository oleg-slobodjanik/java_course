package homework_2;

import java.util.*;

class Student {
    String name;
    int age;
    List<Grade> grades;
    String school;
    Address address;

    // Constructor
    public Student(String name, int age, List<Grade> grades, String school, Address address) {
        this.name = name;
        this.age = age;
        this.grades = grades;
        this.school = school;
        this.address = address;
    }
}
