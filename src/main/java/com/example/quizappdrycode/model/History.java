package com.example.quizappdrycode.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDateTime startedDate;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "exam_participant",
            joinColumns = {@JoinColumn(name = "exam_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private Set<User> participants;

    @ManyToOne
    private Quiz quiz;

    public History(String name) {
        this.name = name;
    }

    public History(String name, LocalDateTime startedDate) {
        this.name = name;
        this.startedDate = startedDate;
    }
}
