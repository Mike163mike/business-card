package org.technosoft.businesscard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.technosoft.businesscard.model.SecurityUser;

import java.util.Optional;

@Repository
public interface SecurityUserRepository extends JpaRepository<SecurityUser, Integer> {

    Optional<SecurityUser> findSecurityUsersByUsername(String username);
}
