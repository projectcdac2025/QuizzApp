package com.quizapp.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "attempts")
public class Attempt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "quiz_id", nullable = false)
    private Quiz quiz;

    @Column(nullable = false)
    private LocalDateTime attemptDate;

    @Column(nullable = false)
    private int score;

    @OneToMany(mappedBy = "attempt", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AttemptAnswer> answers = new ArrayList<>();

    public Attempt() {super();}

	public Attempt(Long id, User user, Quiz quiz, LocalDateTime attemptDate, int score, List<AttemptAnswer> answers) {
		super();
		this.id = id;
		this.user = user;
		this.quiz = quiz;
		this.attemptDate = attemptDate;
		this.score = score;
		this.answers = answers;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	public LocalDateTime getAttemptDate() {
		return attemptDate;
	}

	public void setAttemptDate(LocalDateTime attemptDate) {
		this.attemptDate = attemptDate;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public List<AttemptAnswer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<AttemptAnswer> answers) {
		this.answers = answers;
	}

  
}
