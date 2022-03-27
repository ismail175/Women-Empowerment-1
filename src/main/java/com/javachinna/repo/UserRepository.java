package com.javachinna.repo;

import com.javachinna.model.Profession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.javachinna.model.User;

import java.util.Date;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);

	boolean existsByEmail(String email);

	@Query("select c.profession, count(c) from User c where c.profession=:profession")
	List<Object> nbrUserByProfession(@Param("profession")Profession profession);

	@Query("select  t.users from Training t where t.trainingName=:name")
	List<User> getNbrApprenantByFormation(@Param("name") String name);

	@Query(value="select count(u.idUser) from Training t join t.users u where t.trainingName=:titre")
	Integer getNbrrApprenantByFormation(@Param("titre") String titre);

	@Query("select t.users from  Training t where t.idTraining=:id")
	List<User> getRevenueByFormation(@Param("id") Integer idTraining);

}
