package homework2;

class StudentGrade {
    private String studentName;
    private String school;
    private String subject;
    double score;

    // Constructor
    public StudentGrade(String studentName, String school, String subject, double score) {
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
