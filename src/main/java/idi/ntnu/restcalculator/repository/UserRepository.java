package idi.ntnu.restcalculator.repository;

import idi.ntnu.restcalculator.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Vladimir Lenkov
 * @since 21/03/2023
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
