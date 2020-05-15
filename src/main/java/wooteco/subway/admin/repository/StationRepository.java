package wooteco.subway.admin.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import wooteco.subway.admin.domain.Station;

import java.util.List;
import java.util.Optional;

public interface StationRepository extends CrudRepository<Station, Long> {
    @Override
    List<Station> findAllById(Iterable ids);

    @Override
    List<Station> findAll();

    @Query("select * from station where name = :stationName")
    Optional<Station> findByName(@Param("stationName") String stationName);

    @Query("SELECT * FROM station WHERE name IN (:names)")
    List<Station> findAllByNameIn(@Param("names") List<String> names);

    @Query("SELECT * FROM station WHERE id IN (:ids)")
    List<Station> findAllByIdIn(@Param("ids") List<Long> ids);
}