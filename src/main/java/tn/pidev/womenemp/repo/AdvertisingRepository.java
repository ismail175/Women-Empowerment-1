package tn.pidev.womenemp.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.pidev.womenemp.entities.Advertising;


@Repository
public interface AdvertisingRepository extends CrudRepository<Advertising, Integer> {
}
