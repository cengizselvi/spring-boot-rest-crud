package com.rest.demo.rest;

import com.rest.demo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    @GetMapping("/students")
    public List<Student> getStudent() {

        List<Student> theStudent = new ArrayList<>();
        theStudent.add(new Student("Cengiz","Selvi"));
        theStudent.add(new Student("Buğra","Erten"));
        theStudent.add(new Student("Serkan","Güneş"));

        return theStudent;
    }
}
