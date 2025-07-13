import java.io.*;
import java.util.*;

public class StudentManager {
    private static final String FILE_NAME = "students.txt";

    public static void addStudent(Student student) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true));
        writer.write(student.toFileString());
        writer.newLine();
        writer.close();
    }

    public static List<Student> getAllStudents() throws IOException {
        List<Student> students = new ArrayList<>();
        File file = new File(FILE_NAME);
        if (!file.exists()) return students;

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine()) != null) {
            students.add(Student.fromFileString(line));
        }
        reader.close();
        return students;
    }

    public static Student findStudentById(String id) throws IOException {
        for (Student s : getAllStudents()) {
            if (s.getId().equals(id)) {
                return s;
            }
        }
        return null;
    }

    public static void deleteStudentById(String id) throws IOException {
        List<Student> students = getAllStudents();
        students.removeIf(s -> s.getId().equals(id));

        BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));
        for (Student s : students) {
            writer.write(s.toFileString());
            writer.newLine();
        }
        writer.close();
    }
}