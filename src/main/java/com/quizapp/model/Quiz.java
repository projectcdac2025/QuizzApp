package com.quizapp.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name="quizzes")
public class Quiz {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 255)
	private String title;
	
	 @Column(columnDefinition = "TEXT")
	private String description;
	 
	private String durationMinutes;
	private int totalMarks;
	
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;
	
	 @ManyToOne
	 @JoinColumn(name = "created_by")
	  private User createdBy;
	
//	 @ManyToMany
//	    @JoinTable(
//	        name = "quiz_question",
//	        joinColumns = @JoinColumn(name = "quiz_id"),
//	        inverseJoinColumns = @JoinColumn(name = "question_id")
//	    )
//	    private Set<Question> questions = new HashSet<>();
	 
	 
	 @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL, orphanRemoval = true)
	    private Set<QuizQuestion> quizQuestions = new HashSet<>();

	    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL, orphanRemoval = true)
	    private Set<Attempt> attempts = new HashSet<>();
	    
	    
	    
	 private LocalDateTime createdAt = LocalDateTime.now();

	 public Quiz() {
		super();
	 }

	 public Quiz(Long id, String title, String description, String durationMinutes, int totalMarks, Category category,
			User createdBy, LocalDateTime createdAt) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.durationMinutes = durationMinutes;
		this.totalMarks = totalMarks;
		this.category = category;
		this.createdBy = createdBy;
		this.createdAt = createdAt;
	 }

	 public Long getId() {
		 return id;
	 }

	 public void setId(Long id) {
		 this.id = id;
	 }

	 public String getTitle() {
		 return title;
	 }

	 public void setTitle(String title) {
		 this.title = title;
	 }

	 public String getDescription() {
		 return description;
	 }

	 public void setDescription(String description) {
		 this.description = description;
	 }

	 public String getDurationMinutes() {
		 return durationMinutes;
	 }

	 public void setDurationMinutes(String durationMinutes) {
		 this.durationMinutes = durationMinutes;
	 }

	 public int getTotalMarks() {
		 return totalMarks;
	 }

	 public void setTotalMarks(int totalMarks) {
		 this.totalMarks = totalMarks;
	 }

	 public Category getCategory() {
		 return category;
	 }

	 public void setCategory(Category category) {
		 this.category = category;
	 }

	 public User getCreatedBy() {
		 return createdBy;
	 }

	 public void setCreatedBy(User createdBy) {
		 this.createdBy = createdBy;
	 }

	 public LocalDateTime getCreatedAt() {
		 return createdAt;
	 }

	 public void setCreatedAt(LocalDateTime createdAt) {
		 this.createdAt = createdAt;
	 }
	 
	 
}
