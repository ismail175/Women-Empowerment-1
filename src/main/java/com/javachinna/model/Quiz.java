package com.javachinna.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="Quiz")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Quiz implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer iddQuiz;
	private String quizName;
	private Integer questionNumber;
	private Date quizDate;
	
	@Enumerated(EnumType.STRING)
	private Difficulty difficulty;
	
	
	@ManyToOne
	Training training;
	
	

}
