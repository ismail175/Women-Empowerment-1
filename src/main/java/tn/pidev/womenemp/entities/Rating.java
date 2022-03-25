package tn.pidev.womenemp.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.persistence.*;

@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "Rating")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idRating ;
    @Max(5)
    @Min(0)
    int note ;
    int idUser ;

    @ManyToOne
    @JoinColumn(name="idPublication",nullable = false)
    @JsonIgnore
    Publication publication ;
}
