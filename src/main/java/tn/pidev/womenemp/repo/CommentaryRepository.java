package tn.pidev.womenemp.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.pidev.womenemp.entities.Commentary;

@Repository
public interface CommentaryRepository extends CrudRepository<Commentary, Integer> {
}
