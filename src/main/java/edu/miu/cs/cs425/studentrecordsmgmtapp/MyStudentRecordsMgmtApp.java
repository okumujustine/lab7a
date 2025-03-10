package edu.miu.cs.cs425.studentrecordsmgmtapp;

import edu.miu.cs.cs425.studentrecordsmgmtapp.model.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MyStudentRecordsMgmtApp {

    public static void main(String[] args) {
        Student[] students = {
                new Student(110001, "Dave", "11/18/1951"),
                new Student(110002, "Anna", "12/07/1990"),
                new Student(110003, "Erica", "01/31/1974"),
                new Student(110004, "Carlos", "08/22/2009"),
                new Student(110005, "Bob", "08/05/1994")
        };

        System.out.println("List of Students (Sorted by Name):");
        printListOfStudents(students);

        System.out.println("\nList of Platinum Alumni Students (Sorted by Date of Admission Descending):");
        List<Student> platinumAlumni = getListOfPlatinumAlumniStudents(students);
        platinumAlumni.forEach(System.out::println);

        System.out.println("\nHelloWorld Output:");
        printHelloWorld(new int[]{10, 14, 35, 7, 5, 49});

        System.out.println("\nSecond Biggest Number:");
        System.out.println(findSecondBiggest(new int[]{19, 9, 11, 0, 12}));
    }

    public static void printListOfStudents(Student[] students) {
        Arrays.stream(students)
                .sorted(Comparator.comparing(Student::getName))
                .forEach(System.out::println);
    }

    public static List<Student> getListOfPlatinumAlumniStudents(Student[] students) {
        LocalDate thirtyYearsAgo = LocalDate.now().minusYears(30);
        List<Student> platinumAlumni = new ArrayList<>();

        for (Student student : students) {
            if (student.getDateOfAdmission().isBefore(thirtyYearsAgo)) {
                platinumAlumni.add(student);
            }
        }

        platinumAlumni.sort((s1, s2) -> s2.getDateOfAdmission().compareTo(s1.getDateOfAdmission()));
        return platinumAlumni;
    }

    public static void printHelloWorld(int[] numbers) {
        for (int num : numbers) {
            if (num % 5 == 0 && num % 7 == 0) {
                System.out.println("HelloWorld");
            } else if (num % 5 == 0) {
                System.out.println("Hello");
            } else if (num % 7 == 0) {
                System.out.println("World");
            }
        }
    }

    public static int findSecondBiggest(int[] numbers) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int num : numbers) {
            if (num > max) {
                secondMax = max;
                max = num;
            } else if (num > secondMax && num != max) {
                secondMax = num;
            }
        }
        return secondMax;
    }
}