package tn.pidev.womenemp.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Advertising")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor

public class Advertising {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int idAds;
    private String nameAds;
    private String canalAds;
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Temporal(TemporalType.DATE)
    private Date endDate;
    private int amountStartView;
    private int amountEndView;
    private int costAds;
    private String contentAds;
}
