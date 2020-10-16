package maksim.moiseenko.repositories;

import maksim.moiseenko.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Account, Long> {
    Account findUserByLoginAndPassword(String login, String password);

    Optional<Account> findByLogin(String login);
}
