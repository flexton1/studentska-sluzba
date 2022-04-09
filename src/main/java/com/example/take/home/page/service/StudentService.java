package com.example.take.home.page.service;

import java.util.ArrayList;
import java.util.List;

import com.example.take.home.page.model.StatusStudenta;
import com.example.take.home.page.model.Student;
import com.example.take.home.page.model.User;
import com.example.take.home.page.repository.StatusStudentaRepository;
import com.example.take.home.page.repository.StudentRepository;
import com.example.take.home.page.repository.UserRepository;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final StatusStudentaRepository statusStudentaRepository;
    private final UserRepository userRepository;

    public List<Student> getAllStudents(String userName){
        User user = userRepository.findByUsername(userName).get();
        Long userId1 = user.getUserId();
        List<Student> allStudents = studentRepository.findAll();
       List<Student> result = new ArrayList<Student>();
        for(Student student : allStudents){
            if(student.getUser().getUserId().equals(userId1)){
                student.setUser(null);
                result.add(student);
            }
        }

        return result;
    }

public Student save(Student student, String userId) {
    User user = userRepository.findByUsername(userId).get();
    student.setUser(user);
    studentRepository.save(student);
    return student;
}


    public Student findById(long id){
        if(studentRepository.findById(id).isPresent()){
            return studentRepository.findById(id).get();
        }
        return null;
    }


    public void delete(long id) {
        Student student = findById(id);
        studentRepository.delete(student);
    }

    public StatusStudenta saveStatus(StatusStudenta student){
        
        statusStudentaRepository.save(student);
        return student;

    }
    
}
