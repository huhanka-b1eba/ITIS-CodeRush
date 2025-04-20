package aa.tulybaev.itiscoderush.repository;

import aa.tulybaev.itiscoderush.model.Role;
import aa.tulybaev.itiscoderush.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

    List<User> findByNameContainingIgnoreCase(String name);

    @Query("SELECT u FROM User u WHERE u.role = :role ORDER BY u.name")
    List<User> findByRoleOrderedByName(@Param("role") Role role);
}