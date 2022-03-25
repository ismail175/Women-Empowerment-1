package tn.pidev.womenemp.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.pidev.womenemp.entities.Comment;


@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer> {

}
