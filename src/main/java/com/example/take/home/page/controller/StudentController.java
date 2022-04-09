package com.example.take.home.page.controller;

import java.util.List;

import com.example.take.home.page.model.StatusStudenta;
import com.example.take.home.page.model.Student;
import com.example.take.home.page.service.StudentService;
import com.fasterxml.jackson.databind.ser.std.StaticListSerializerBase;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/student")
@AllArgsConstructor
public class StudentController {
   public final StudentService studentService; 
    //ucitaj tabelu
    @GetMapping("/tabela/{userName}")
    public List<Student> getAllStudents(@PathVariable String userName){
    List<Student> studentTabela = studentService.getAllStudents(userName);
    return studentTabela; 
};

    //edit and add student
    @PostMapping("/edit/{userId}")
    public ResponseEntity<Student> save(@RequestBody Student student, @PathVariable String userId){
       Student studentOne = studentService.save(student, userId);
       return new ResponseEntity<Student>(studentOne, HttpStatus.OK);
    }

    
    @PostMapping("/status")
    public ResponseEntity<StatusStudenta> saveStatus(@RequestBody StatusStudenta student){
        StatusStudenta statusStudenta = studentService.saveStatus(student);
        return new ResponseEntity<StatusStudenta>(statusStudenta, HttpStatus.OK);
    }

    //get specific student
    @GetMapping("/{id}")
    public ResponseEntity<Student> get(@PathVariable("id") Long id){
        Student student = studentService.findById(id);
        return new ResponseEntity<Student>(student, HttpStatus.OK);
    }

    //brisanje
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id")Long id ){
        studentService.delete(id);
        return new ResponseEntity<String>("Student izbrisan", HttpStatus.OK);
    }


}
