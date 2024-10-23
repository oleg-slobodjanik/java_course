package com.slobodianyk.homework2;

@SuppressWarnings("checkstyle:RegexpSingleline")
class StudentGrade {
    private final String studentName;
    private final String school;
    private final String subject;
    private final double score;

    public String getStudentName() {
        return studentName;
    }

    public String getSchool() {
        return school;
    }

    public String getSubject() {
        return subject;
    }

    public double getScore() {
        return score;
    }

    // Constructor
    StudentGrade(String studentName, String school, String subject, double score) {
        this.studentName = studentName;
        this.school = school;
        this.subject = subject;
        this.score = score;
    }

    @Override
    public String toString() {
        return studentName + ", " + school + ", " + subject + ", " + score;
    }
}
