package com.hibernate.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "student")
@Setter
@Getter
@NoArgsConstructor
public class Studet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "student_name")
    private String studentName;
    @ManyToMany
    @JoinTable(
            name = "course_student",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )

    private List<Course> courses;
    public Studet(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public String toString() {
        return "Studet{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                ", courses=" + courses +
                '}';
    }
}
