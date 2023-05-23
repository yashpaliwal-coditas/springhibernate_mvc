package org.example;

import org.example.dao.StudentDao;
import org.example.entities.Students;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDao = context.getBean("StudentDao", StudentDao.class);
//        Students student = new Students();
//        student.setStudentId(1);
//        student.setName("yash");
//        student.setCity("mainpuri");
//        studentDao.insert(student);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        boolean flag =true;
        int studentId;
        Students student;
        while (flag) {
            System.out.println("1. add student");
            System.out.println("2. display all student");
            System.out.println("3. display single student");
            System.out.println("4. update student");
            System.out.println("5. delete student");
            System.out.println("0. Exit");
            try {
                int choice = Integer.parseInt(bufferedReader.readLine());
                switch (choice) {
                    case 1:
                        student = new Students();
                        System.out.println("Enter the id ");
                        student.setStudentId(Integer.parseInt(bufferedReader.readLine()));
                        System.out.println("Enter the name");
                        student.setName(bufferedReader.readLine());
                        System.out.println("Enter the city");
                        student.setCity(bufferedReader.readLine());
                        studentDao.insert(student);
                        System.out.println("student has been inserted");
                        break;
                    case 2: List<Students> studentsList = studentDao.getAllStudent();
                    for (Students students:studentsList){
                        System.out.println(students);
                    }
                        break;
                    case 3:
                        System.out.println("Enter the id to be displayed");
                        studentId = Integer.parseInt(bufferedReader.readLine());
                        System.out.println(studentDao.getStudent(studentId));
                        break;
                    case 4:
                        System.out.println("Enter the id to be updated");
                        studentId = Integer.parseInt(bufferedReader.readLine());
                        Students students = studentDao.getStudent(studentId);
                        students.setCity("pune");
                        studentDao.update(students);
                        System.out.println("student has been updated");
                        break;
                    case 5:System.out.println("Enter the id to be updated");
                        studentId = Integer.parseInt(bufferedReader.readLine());
                        studentDao.delete(studentId);
                        System.out.println("student has been deleted");
                        break;
                    case 0: flag = false;
                        break;
                }
            }catch (Exception e){
                System.out.println("wrong input type");
                System.out.println(e);
            }
        }
    }
}