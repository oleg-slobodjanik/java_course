package homework_2;

import java.util.*;
import java.util.stream.Collectors;

public class StudentGradesProcessor {
    public static void main(String[] args) {
        // Sample data
        List<Student> students = Arrays.asList(
                new Student("Alice", 16, Arrays.asList(new Grade("Math", 88), new Grade("Science", 92)), "High School A", new Address("New York", "1st Ave")),
                new Student("Bob", 14, Arrays.asList(new Grade("Math", 70), new Grade("Science", 75)), "High School B", new Address("Los Angeles", "2nd St")),
                new Student("Charlie", 17, Arrays.asList(new Grade("Math", 95), new Grade("Science", 89)), "High School A", new Address("New York", "3rd Ave")),
                new Student("David", 16, Arrays.asList(new Grade("Math", 88), new Grade("History", 84)), "High School C", new Address("New York", "4th Ave")),
                new Student("Eve", 15, Arrays.asList(new Grade("Math", 85), new Grade("Science", 82)), "High School D", new Address("Chicago", "5th Ave"))
        );

        // Process students using Stream API
        List<StudentGradeRecord> topGrades = students.stream()
                .filter(s -> s.age > 15 && "New York".equals(s.address.city)) // Filter students
                .flatMap(s -> s.grades.stream()
                        .map(g -> new StudentGradeRecord(s.name, s.school, g.subject, g.score))) // Map grades
                .sorted(Comparator.comparingDouble((StudentGradeRecord r) -> r.score).reversed()) // Sort by score
                .limit(3) // Get top 3 grades
                .collect(Collectors.toList()); // Collect results

        // Output the top 3 grades
        topGrades.forEach(System.out::println);
    }
}
