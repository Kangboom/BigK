package com.example.BigK.repository;

import com.example.BigK.entity.Notice;
import com.example.BigK.entity.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByLoginId(String loginId);
    Optional<User> findByLoginId(String loginId);

    List<Notice> findAll(Specification<Notice> noticeSpecification);
}
