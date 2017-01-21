package com.managedbean;

import java.util.List;

import javax.annotation.PostConstruct;

import com.model.Student;
import com.model.StudentConverter;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class StudentMB {

    private Date myDate;
    private Student selectedStudent;
    private List<Student> myStudents;

    public StudentMB() {
        myDate=new Date();
    }

    
    
    
    
    public Student getSelectedStudent() {
        return selectedStudent;
    }

    public void setSelectedStudent(Student selectedStudent) {
        this.selectedStudent = selectedStudent;
    }

    public List<Student> getStudents() {
        students=StudentConverter.studentDB;
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    private List<Student> students;

    public Date getMyDate() {
        return myDate;
    }

    public void setMyDate(Date myDate) {
        this.myDate = myDate;
    }

    @PostConstruct
    public void init() {
        myStudents = StudentConverter.studentDB;
    }

}
