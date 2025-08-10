package com.quizapp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "attempt_answers")
public class AttemptAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "attempt_id", nullable = false)
    private Attempt attempt;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    @ManyToOne
    @JoinColumn(name = "chosen_choice_id", nullable = false)
    private Choice chosenChoice;

    public AttemptAnswer() {}

	public AttemptAnswer(Long id, Attempt attempt, Question question, Choice chosenChoice) {
		super();
		this.id = id;
		this.attempt = attempt;
		this.question = question;
		this.chosenChoice = chosenChoice;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Attempt getAttempt() {
		return attempt;
	}

	public void setAttempt(Attempt attempt) {
		this.attempt = attempt;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Choice getChosenChoice() {
		return chosenChoice;
	}

	public void setChosenChoice(Choice chosenChoice) {
		this.chosenChoice = chosenChoice;
	}

 
}
