package com.example.take.home.page.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long pkStudentId;
    private String brojIndeksa;
    private String ime;
    private String prezime;
    private String godinaStudija;
    private String statusStudenta;







    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private User user;


    public void setUser(User user){
        this.user = user;
    }

    public User getUser(){
        return this.user;
    }
}
