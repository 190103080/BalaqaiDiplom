package kz.diplom.balaqai.repository;

import jakarta.transaction.Transactional;
import kz.diplom.balaqai.models.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface PermissionRepository extends JpaRepository<Permission, Long> {

    Permission findByName(String name);

}
