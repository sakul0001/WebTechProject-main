package edu.tcu.cs.superfrogproject.dao;

import edu.tcu.cs.superfrogproject.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    public User findByUsername(String username);
}
