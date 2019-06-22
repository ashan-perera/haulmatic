package com.example.haulmatic.controller;

import com.example.haulmatic.model.Student;
import com.example.haulmatic.response.ReturnFormat;
import com.example.haulmatic.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/student")
@CrossOrigin(origins = "*")

public class StudentController {

    @Autowired
    StudentService studentService;
    ReturnFormat returnFormat;

    @PostMapping("/saveStudent")
    public ReturnFormat saveStudent(@RequestBody Student student){

        try{

            studentService.addStudent(student);
            returnFormat = new ReturnFormat(ReturnFormat.Status.SUCCESS, "Successful!", student);

        } catch (Exception e) {

            e.printStackTrace();
            returnFormat = new ReturnFormat(ReturnFormat.Status.ERROR, "Unsuccessful!");

        }

        return returnFormat;

    }

    @PutMapping(value = "/updateStudent")
    public ReturnFormat updateStudent(@RequestBody Student student){

        try {

            studentService.updateStudent(student);
            returnFormat = new ReturnFormat(ReturnFormat.Status.SUCCESS, "Successful!", student);

        } catch ( Exception e ) {

            e.printStackTrace();
            returnFormat = new ReturnFormat(ReturnFormat.Status.ERROR, "Unsuccessful!");
        }

        return returnFormat;

    }

    @GetMapping(value = "/listAllStudent")
    public ReturnFormat listAllStudent(){

        try {

            List<Student> studentList = studentService.listAllStudent();
            returnFormat = new ReturnFormat(ReturnFormat.Status.SUCCESS, "Successful!", studentList);

        } catch ( Exception e ) {

            e.printStackTrace();
            returnFormat = new ReturnFormat(ReturnFormat.Status.ERROR, "Unsuccessful!");
        }

        return returnFormat;
    }

    @DeleteMapping(value = "/deleteStudent/{studentId}")
    public ReturnFormat deleteStudent(@PathVariable int studentId){

        try {

            studentService.deleteStudent(studentId);
            returnFormat = new ReturnFormat(ReturnFormat.Status.SUCCESS, "Successful!");

        } catch ( Exception e ) {

            e.printStackTrace();
            returnFormat = new ReturnFormat(ReturnFormat.Status.ERROR, "Unsuccessful!");
        }

        return returnFormat;
    }

}
