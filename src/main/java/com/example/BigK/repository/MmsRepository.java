package com.example.BigK.repository;

import com.example.BigK.entity.Mms;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface MmsRepository extends JpaRepository<Mms, Long> {
  Optional<Mms> findByEmail(String email);
}