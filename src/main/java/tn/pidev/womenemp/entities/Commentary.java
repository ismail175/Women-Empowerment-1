package tn.pidev.womenemp.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "Commentary")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor

public class Commentary {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private int idCommentary;
    @Temporal(TemporalType.DATE)
    private Date dateCommentary;
    private String contentCommentary;

}
