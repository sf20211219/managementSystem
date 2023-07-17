package service;

import view.Userviewer;

import java.util.Scanner;

public class UserService {
    private StudentList list = StudentList.getListSingleton();
    private SupportService ss = new SupportService();
    private Userviewer ui = new Userviewer();

    int choose() {
        ui.choose();
        int n = ss.inputIntException();
        return n;
    }
    int login() {
        Scanner sc = new Scanner(System.in);

        while(true) {
            ui.inputId();
            String id = sc.nextLine();
            ui.inputPw();
            String pw = sc.nextLine();

            if (id.equals("admin") && pw.equals("@admin")) {
                return -1;
            } else if (!list.getList().isEmpty()) {
                int index = ss.checkId(id);

                if (index != -1 && ss.checkPw(index, pw)) {
                    return index;
                }
            }
            ui.failLogin();
        }
    }
}