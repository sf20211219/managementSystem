package domain;

public class Grade {
    private int kor;
    private int math;
    private int eng;
    private double avg;

    public Grade (int kor, int math, int eng) {
        this.kor = kor;
        this.math = math;
        this.eng = eng;
        this.avg = (double) (kor + math + eng) / 3;
    }

    public int getKor() {
        return kor;
    }

    public void setKor(int kor) {
        this.kor = kor;
        setAvg(this.kor, this.math, this.eng);
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
        setAvg(this.kor, this.math, this.eng);
    }

    public int getEng() {
        return eng;
    }

    public void setEng(int eng) {
        this.eng = eng;
        setAvg(this.kor, this.math, this.eng);
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(int kor, int math, int eng) {
        double avg = (double) (kor + math + eng) / 3;
        this.avg = avg;
    }
}
