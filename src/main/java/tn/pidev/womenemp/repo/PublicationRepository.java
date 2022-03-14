package tn.pidev.womenemp.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.pidev.womenemp.entities.Publication;

@Repository
public interface PublicationRepository extends CrudRepository<Publication, Integer> {
}
