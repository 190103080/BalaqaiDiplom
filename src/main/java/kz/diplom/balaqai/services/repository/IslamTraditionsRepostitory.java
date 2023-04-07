package kz.diplom.balaqai.services.repository;

import kz.diplom.balaqai.models.IslamTraditions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IslamTraditionsRepostitory extends JpaRepository<IslamTraditions, Long> {
}
