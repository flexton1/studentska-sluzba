package com.example.take.home.page.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long userId;
    @NotBlank(message = "Korisničko ime je obavezno")
    private String username;
    @NotBlank(message = "Pasvord je obavezan")
    private String password;
    @Email
    @NotEmpty(message = "Email je obavezan")
    private String email;
    private Instant created;
    private boolean enabled;





    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<Student> students = new HashSet<>();

    public Set<Student> getStudents(){
        return this.students;
    }
}
