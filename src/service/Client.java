package service;

import domain.user.Student;
import view.AdminViewer;

public class Client {
    public void run() {
        UserService us = new UserService();

        while(true) {
            switch (us.choose()) {
                case 1:
                    int user = us.login();

                    if (user == -1) {
                        adminRun();
                    } else {
                        StudentList list = StudentList.getListSingleton();
                        Student student = list.getList().get(user);
                        studentRun(student);
                    }
                    break;
                case 2:
                    return;
                default:
                    System.out.println("재입력 바랍니다.");
                    break;
            }
        }
    }
    private void adminRun() {
        AdminService as = new AdminService();
        new AdminViewer().succeedLogin();

        while(as.choose() != 4) {

        }
    }
    private void studentRun(Student student) {
        System.out.println("0000");
    }
}
