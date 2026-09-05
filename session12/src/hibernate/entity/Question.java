package hibernate.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "question")
@Setter
@Getter
@NoArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "question_name")
    private String questionName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "qid")
    private List<Answer> answers;

    public Question(String questionName) {
        this.questionName = questionName;
    }
}
