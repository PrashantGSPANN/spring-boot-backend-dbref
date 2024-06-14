package com.example.mogo.mongodbexample.controller;

import com.example.mogo.mongodbexample.models.StudentDTO;
import com.example.mogo.mongodbexample.pojo.Studentpojo;
import com.example.mogo.mongodbexample.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/add")
    public ResponseEntity<StudentDTO> addStudent(@RequestBody Studentpojo student){
        StudentDTO studentDTO;
        studentDTO = new StudentDTO();
        studentDTO.setName(student.getName());
        studentDTO.setCity(student.getCity());
        studentDTO.setCollege(student.getCollege());
        return  studentService.setStudent(studentDTO);
    }
    @GetMapping("/fetch")
    public ResponseEntity<List<StudentDTO>> getStudents(){
        return  studentService.getStudent();
    }
//    @PostMapping("/addstudentmarks")
//    public ResponseEntity<StudentMarkspojo> addStudentMarks(@RequestBody StudentMarkspojo studentMarks){
//        return studentService.setStudentMarks(studentMarks);
//    }
}
