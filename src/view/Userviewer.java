package view;

public class Userviewer {
    public void choose() {
        System.out.println("| 1.로그인 | 2.종료 |");
    }
    public void inputId() {
        System.out.println("아이디 입력: ");
    }
    public void inputPw() {
        System.out.println("비밀번호 입력: ");
    }
    public void failLogin() {
        System.out.println("아이디 또는 비밀번호를 잘못 입력하셨습니다.");
    }
}