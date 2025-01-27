package ru.elizarov.study;

import java.util.List;
import java.util.Random;

public class StudentService {
    private static final Random random = new Random();

    public static void addRandomGrades(List<Student> students) {
        int randomGrade = random.nextInt(10) + 1; // Оценка от 1 до 10

        // можно ли добавить оценку всем студентам
        for (Student student : students) {
            try {
                // пробуем добавить оценку (вызовет исключение, если оценка некорректна)
                student.addGrade(randomGrade);
            } catch (InvalidGradeException e) {
                throw new GradeAdditionException(
                        "Невозможно добавить оценку " + randomGrade + " студенту " + student.getName()
                );
            }
        }

        // если все проверки прошли успешно, добавляем оценку всем студентам
        for (Student student : students) {
            student.addGrade(randomGrade);
        }
    }
}
