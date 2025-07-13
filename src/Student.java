public class Student {
    private String id;
    private String name;
    private int age;
    private String course;

    public Student(String id, String name, int age, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
    }

    public String toFileString() {
        return id + "," + name + "," + age + "," + course;
    }

    public static Student fromFileString(String line) {
        String[] parts = line.split(",");
        return new Student(parts[0], parts[1], Integer.parseInt(parts[2]), parts[3]);
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Course: " + course;
    }
}