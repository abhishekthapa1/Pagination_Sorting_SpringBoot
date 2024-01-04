package paginationandsorting.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import paginationandsorting.model.Countries;

@Repository
public interface CountryRepository extends JpaRepository<Countries,Long> {
}
