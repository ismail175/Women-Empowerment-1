package tn.pidev.womenemp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name="Publication")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Publication implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int idPublication;
    @Temporal(TemporalType.DATE)
    private Date datePublication;
    private String contentPublication;




    @OneToMany(mappedBy ="publication")
    @JsonIgnoreProperties("publication")
    List<Comment> Comments ;

    @OneToMany(mappedBy = "publication", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("publication")
    List<Rating> ratings;

  /*  @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idUser",nullable = false)
    @JsonIgnore
    private User user;*/


}