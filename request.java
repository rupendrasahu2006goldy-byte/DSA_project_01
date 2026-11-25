public class Request {
    Student student;
    int priority;
    int sequence;

    public Request(Student student, int priority, int sequence) {
        this.student = student;
        this.priority = priority;
        this.sequence = sequence;
    }
}
