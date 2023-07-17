package service;

import domain.Gender;
import domain.user.Student;
import view.AdminViewer;

import java.util.Scanner;

public class SupportService {
    private StudentList list = StudentList.getListSingleton();
    private AdminViewer adminUi = new AdminViewer();
    private Scanner sc = new Scanner(System.in);

    String inputId() {
        while(true) {
            adminUi.inputId();
            String id = Integer.toString(inputIntException());

            if (!list.getList().isEmpty()) {
                if (checkId(id) == -1) {
                    return id;
                }
            } else {
                return id;
            }
            adminUi.redundancyId();
        }
    }
    String inputName() { //특수문자, 숫자 오류 처리 코드 추가
        adminUi.inputName();
        String name = sc.nextLine();
        return name;
    }
    String inputBirthdate() { //달력 오류 처리 코드 추가
        adminUi.inputBirthdate();
        String birthdate = sc.nextLine();
        return birthdate;
    }
    Gender inputGender() {
        while (true) {
            adminUi.inputGender();
            switch (inputIntException()) {
                case 1:
                    return Gender.M;
                case 2:
                    return Gender.F;
                default:
                    System.out.println("재입력 바랍니다.");
                    break;
            }
        }
    }
    int inputScore(int score) {
        if (100 < score || score < 0) {
            adminUi.inputErrorScore();
            return inputScore(inputIntException());
        }
        return score;
    }
    int checkId(String id) {
        for(int i = 0; i < list.getList().size(); i++) {
            Student info = list.getList().get(i);

            if (info.getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }
    boolean checkPw(int index, String pw) {
        Student info = list.getList().get(index);

        if (info.getPw().equals(pw)) {
            return true;
        }
        return false;
    }
    int inputIntException() {
        try {
            int input = Integer.parseInt(sc.nextLine());
            if (input < 0) {
                throw new NumberFormatException();
            }
            return input;
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException 발생 - 재입력 바랍니다.");
            return -1;
        }
    }
}