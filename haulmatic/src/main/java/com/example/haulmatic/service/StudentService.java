package com.example.haulmatic.service;

import com.example.haulmatic.model.Student;
import com.example.haulmatic.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @PersistenceContext
    EntityManager entityManager;

    public void addStudent(Student student){

        studentRepository.save(student);
        studentRepository.findAll();

    }

    public void updateStudent(Student student) {

        studentRepository.saveAndFlush(student);

    }

    public List<Student> listAllStudent() {

        return studentRepository.findAll();

    }

    public Student getStudentById(int studentId) {

        return entityManager.find(Student.class, studentId);

    }

    public void deleteStudent(int studentId) {

        studentRepository.deleteById(studentId);

    }

}
