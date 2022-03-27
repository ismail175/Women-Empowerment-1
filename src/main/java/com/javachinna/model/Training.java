package com.javachinna.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;


@Entity
@Table(name="Training")
@Getter
@Setter
@ToString

@AllArgsConstructor
@NoArgsConstructor
public class Training implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idTraining;
	private String trainingName;
	private Integer cost;

	
	@Enumerated(EnumType.STRING)
	private TrainingType trainingType;
	@Enumerated(EnumType.STRING)
	private CERTIFICAT certificat;
	private Date sessionStartDate;
	private Date sessionEndDate;
	private Integer maximumParticipantNumber;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="training")
	private Set<Quiz> Quiz;
	
	@ManyToMany
	@JsonIgnore
	private Set<User> users;
	

}
