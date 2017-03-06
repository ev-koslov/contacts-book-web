package ev.koslov.db.repository;

import ev.koslov.db.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Jpa repository for Account entity
 */
public interface AccountJpaRepository extends JpaRepository<Account, String> {

}
