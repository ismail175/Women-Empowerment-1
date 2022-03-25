package com.javachinna.repo;

import com.javachinna.model.Abonement;
import com.javachinna.model.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface AbonementRepository extends JpaRepository<Abonement,Long> {

    @Query("select c.level, count(c) from Abonement c where c.datedebut>=:dated and c.datefin<=:datef group by c.level")
    List<Object> nbrAbonementByLevel(@Param ("dated") Date datedebut,@Param ("datef") Date datefin);
}
