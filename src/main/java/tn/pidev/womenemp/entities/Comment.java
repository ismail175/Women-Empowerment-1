package tn.pidev.womenemp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "Comment")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor

public class Comment {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private int idComment;
    @Temporal(TemporalType.DATE)
    private Date dateComment;
    private String contentComment;

    @ManyToOne
    @JoinColumn(name="idPublication",nullable = false)
    @JsonIgnore
    private Publication publication ;


}
