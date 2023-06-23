package kz.diplom.balaqai.repository;

import kz.diplom.balaqai.component.PasswordResetLinkGenerator;
import kz.diplom.balaqai.models.PasswordResetRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface PasswordResetRequestRepository extends JpaRepository<PasswordResetRequest, Long> {

    PasswordResetRequest findByEmail(String email);

}
