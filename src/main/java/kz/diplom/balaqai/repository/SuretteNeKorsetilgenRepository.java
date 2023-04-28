package kz.diplom.balaqai.repository;

import kz.diplom.balaqai.models.SuretteNeKorsetilgen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface SuretteNeKorsetilgenRepository extends JpaRepository<SuretteNeKorsetilgen, Long> {
}
