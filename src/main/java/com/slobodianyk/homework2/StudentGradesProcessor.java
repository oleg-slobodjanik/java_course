package com.slobodianyk.homework2;

import java.util.List;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class StudentGradesProcessor {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Oleg", 16, Arrays.asList(new Grade("Math", 88), new Grade("Science", 92)), "High School A", new Address("Kharkiv", "1st Ave")),
                new Student("Angela", 14, Arrays.asList(new Grade("Math", 70), new Grade("Science", 75)), "High School B", new Address("Lviv", "2nd St")),
                new Student("Nikita", 17, Arrays.asList(new Grade("Math", 95), new Grade("Science", 89)), "High School A", new Address("Kharkiv", "3rd Ave")),
                new Student("Natasha", 16, Arrays.asList(new Grade("Math", 88), new Grade("History", 84)), "High School C", new Address("Kharkiv", "4th Ave")),
                new Student("Roma", 15, Arrays.asList(new Grade("Math", 85), new Grade("Science", 82)), "High School D", new Address("Kyiv", "5th Ave"))
        );

        List<StudentGrade> topGrades = students.stream()
                .filter(s -> s.age > 15 && "Kharkiv".equals(s.address.city))
                .flatMap(s -> s.grades.stream()
                        .map(g -> new StudentGrade(s.name, s.school, g.subject, g.score)))
                .sorted(Comparator.comparingDouble((StudentGrade r) -> r.score).reversed())
                .limit(3)
                .collect(Collectors.toList());

        topGrades.forEach(System.out::println);
    }
}
