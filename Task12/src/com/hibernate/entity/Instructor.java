package com.hibernate.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "instructor")
@Setter
@Getter
@NoArgsConstructor
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "instructor_name")
    private String instructorName;

    @OneToMany(mappedBy = "instructor", cascade = CascadeType.ALL)
//    @JoinColumn(name = "course_id")
    private List<Course> courses;


    public Instructor(String instructorName) {
        this.instructorName = instructorName;
    }
}
