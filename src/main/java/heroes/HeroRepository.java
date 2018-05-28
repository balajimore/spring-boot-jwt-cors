package heroes;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "heroes", path = "heroes")
public interface HeroRepository extends CrudRepository<Hero, Long> {

    @Query("from Hero h where lower(h.name) like CONCAT('%', lower(:name), '%')")
    public Iterable<Hero> findByName(@Param("name") String name);

}