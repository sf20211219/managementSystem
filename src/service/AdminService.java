package service;

import domain.Gender;
import domain.Grade;
import domain.user.Student;
import view.AdminViewer;

import java.util.Scanner;

public class AdminService {
    private StudentList list = StudentList.getListSingleton();
    private SupportService ss = new SupportService();
    private AdminViewer adminUi = new AdminViewer();

    int choose() {
        adminUi.choose();
        switch (ss.inputIntException()) {
            case 1: //등록
                insert();
                break;
            case 2: //조회
                search();
                break;
            case 3: //전체 출력
                print();
                break;
            case 4:
                return 4;
            default:
                System.out.println("재입력 바랍니다.");
                break;
        }
        return 0;
    }
    void insert() {
        String id = ss.inputId();
        String name = ss.inputName();
        String birthdate = ss.inputBirthdate();
        Gender gender = ss.inputGender();

        list.insert(new Student(id, name, birthdate, gender));
    }
    void search() {
        Scanner sc = new Scanner(System.in);

        if (!list.getList().isEmpty()) {
            adminUi.inputId();
            String id = sc.nextLine();
            int index = ss.checkId(id);

            if (index != -1) {
                Student student = list.getList().get(index);
                adminUi.print();
                adminUi.printInfo(student);
                while(choose2(student) != 4) {

                }
                return;
            }
        }
        adminUi.failPrint();
    }
    int choose2(Student student) {
        adminUi.choose2();
        switch (ss.inputIntException()) {
            case 1:
                insertGrade(student);
                break;
            case 2:
                printGrade(student);
                break;
            case 3:
                delete(student);
                return 4;
            case 4:
                return 4;
            default:
                System.out.println("재입력 바랍니다.");
                break;
        }
        return 0;
    }
    void insertGrade(Student student) {
        if (student.getGrade() == null) {
            adminUi.inputKor();
            int kor = ss.inputScore(ss.inputIntException());
            adminUi.inputMath();
            int math = ss.inputScore(ss.inputIntException());
            adminUi.inputEng();
            int eng = ss.inputScore(ss.inputIntException());

            student.setGrade(new Grade(kor, math, eng));
        } else {
            student.setGrade(updateGrade(student));
        }
    }
    Grade updateGrade(Student student) {
        Grade grade = student.getGrade();
        while(true) {
            adminUi.chooseSubject();
            switch (ss.inputIntException()) {
                case 1:
                    adminUi.inputKor();
                    grade.setKor(ss.inputScore(ss.inputIntException()));
                    return grade;
                case 2:
                    adminUi.inputMath();
                    grade.setMath(ss.inputScore(ss.inputIntException()));
                    return grade;
                case 3:
                    adminUi.inputEng();
                    grade.setEng(ss.inputScore(ss.inputIntException()));
                    return grade;
                default:
                    System.out.println("재입력 바랍니다.");
                    break;
            }
        }
    }
    void delete(Student student) {
        list.delete(student);
        adminUi.succeedDelete();
    }
    void print() {
        if (!list.getList().isEmpty()) {
            adminUi.print();
            for(int i = 0; i < list.getList().size(); i++) {
                Student info = list.getList().get(i);
                adminUi.printInfo(info);
            }
            return;
        }
        adminUi.failPrint();
    }
    void printGrade(Student student) {
        if (student.getGrade() != null) {
            adminUi.printSubject();
            adminUi.printScore(student.getGrade());
        } else {
            adminUi.failPrintScore();
        }
    }
}