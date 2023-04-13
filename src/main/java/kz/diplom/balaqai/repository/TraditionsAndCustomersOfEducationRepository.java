package kz.diplom.balaqai.repository;

import kz.diplom.balaqai.models.TraditionsAndCustomsOfEducation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface TraditionsAndCustomersOfEducationRepository extends JpaRepository<TraditionsAndCustomsOfEducation, Long> {
}
