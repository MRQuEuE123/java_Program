import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public  class School {

    private static long NUMBER_STUDENT;
    private  String firstName;
    private String lastName;
    private double gradeAVG;

    @Override
    public String toString() {
        return "Student: " + firstName +" "+lastName+" AVG: "+gradeAVG;
    }

    public double getNumberOfStudent(){
        return gradeAVG;
    }

    School(String firstName, String lastName, double gradeAVG){
        this.firstName = firstName;
        this.lastName = lastName;
        this.gradeAVG = gradeAVG;
        NUMBER_STUDENT++;
        System.out.println("Студентов теперь "+NUMBER_STUDENT);
        System.out.println(this);
    }

    public static void main(String[] args) {
        List<School> students = new ArrayList<>();
        String filename="D:\\Java\\2025\\java_Program\\Module_03\\src\\student.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";"); // Разделитель по умолчанию
                if (parts.length == 3) {
                    String firstName = parts[0].trim();
                    String lastName = parts[1].trim();
                    double grade = Double.parseDouble(parts[2].trim());
                    students.add(new School(firstName, lastName, grade)); // Создаем объект
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Ошибка формата данных: " + e.getMessage());
        }

        // Расчет среднего балла
        double total = 0;
        for (School st : students) {
            total += st.gradeAVG;
        }
        double average = total / students.size();
        System.out.printf("\nСредний балл: %.2f\n", average);

        // Вывод студентов с баллом ниже среднего
        System.out.println("Студенты с баллом ниже среднего:");
        for (School st : students) {
            if (st.gradeAVG < average) {
                System.out.println(st);
            }
        }

    }

}
