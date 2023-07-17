package service;

import domain.user.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentList {
    private static StudentList listSingleton = new StudentList();
    private List<Student> list = new ArrayList<Student>();

    private StudentList () {

    }

    public void insert(Student student) {
        list.add(student);
    }
    public void delete(Student student) {
        list.remove(student);
    }
    public static StudentList getListSingleton() {
        return listSingleton;
    }

    public List<Student> getList() {
        return list;
    }

    public void setList(List<Student> list) {
        this.list = list;
    }
}
