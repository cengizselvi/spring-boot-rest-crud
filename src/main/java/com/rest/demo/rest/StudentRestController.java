package com.rest.demo.rest;

import com.rest.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private  List<Student> theStudent;

    @PostConstruct
    public void loadData() { // hemen çalışacak ve öğrenciler array'e aktarılmış olacak
        theStudent = new ArrayList<>();
        theStudent.add(new Student("Cengiz","Selvi"));
        theStudent.add(new Student("Buğra","Erten"));
        theStudent.add(new Student("Serkan","Güneş"));
    }

    @GetMapping("/students")
    public List<Student> getStudent() {

        return theStudent;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        if ((studentId>=theStudent.size()) || (studentId<0)){
            throw new StudentNotFoundException("Ogrenci ID bulunamadı - "
            + studentId);
        }
        return theStudent.get(studentId);
    }



}
