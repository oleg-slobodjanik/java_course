package homework_2;

class StudentGradeRecord {
    String studentName;
    String school;
    String subject;
    double score;

    // Constructor
    public StudentGradeRecord(String studentName, String school, String subject, double score) {
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
