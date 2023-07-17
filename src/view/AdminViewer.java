package view;

import domain.Grade;
import domain.user.Student;

public class AdminViewer {
    public void succeedLogin() {
        System.out.println("***** 관리자 모드로 로그인 하였습니다. *****");
    }
    public void choose() {
        System.out.println("***** 학생 관리 시스템 *****");
        System.out.println("| 1.등록 | 2.조회 | 3.출력 | 4.로그아웃 |");
    }
    public void choose2() {
        System.out.println("해당 학생 정보 수정 또는 삭제를 원하시는 경우 선택해주세요.");
        System.out.println("| 1.성적관리 | 2.성적조회 | 3.삭제 | 4.뒤로가기 |");
    }
    public void chooseSubject() {
        System.out.println("수정할 점수의 과목을 선택해주세요.");
        System.out.println("| 1.국어 | 2.수학 | 3.영어 |");
    }
    public void inputId() {
        System.out.println("학생번호 입력: ");
    }
    public void inputName() {
        System.out.println("이름 입력: ");
    }
    public void inputBirthdate() {
        System.out.println("생년월일 입력: ");
    }
    public void inputGender() {
        System.out.println("| 1.남자 | 2.여자 |");
    }
    public void inputKor() {
        System.out.println("국어 점수 입력: ");
    }
    public void inputMath() {
        System.out.println("수학 점수 입력: ");
    }
    public void inputEng() {
        System.out.println("영어 점수 입력: ");
    }
    public void print() {
        System.out.println("| 학생번호 | 이름 | 생년월일 | 성별 |");
    }
    public void printInfo(Student student) {
        System.out.println("| " + student.getId() + " | " + student.getName() + " | " + student.getBirthdate() + " | " + student.getGender() + " |");
    }
    public void printSubject() {
        System.out.println("| 국어 | 수학 | 영어 | 평균 |");
    }
    public void printScore(Grade grade) {
        System.out.println("| " + grade.getKor() + " | " + grade.getMath() + " | " + grade.getEng() + " | " + String.format("%.2f", grade.getAvg()) + " |");
    }
    public void failPrint() {
        System.out.println("등록된 학생이 없습니다.");
    }
    public void redundancyId() {
        System.out.println("이미 등록된 학생번호입니다.");
    }
    public void failPrintScore() {
        System.out.println("등록된 성적이 존재하지 않습니다.");
    }
    public void inputErrorScore() {
        System.out.println("올바르지 않은 값입니다. 다시 입력해주세요.");
    }
    public void succeedDelete() {
        System.out.println("삭제가 완료 되었습니다.");
    }
}