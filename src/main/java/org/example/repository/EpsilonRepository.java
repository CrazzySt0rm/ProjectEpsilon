package org.example.repository;

import org.example.model.Epsilon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EpsilonRepository extends JpaRepository<Epsilon, Long> {

    List<Epsilon> findByTitle(String title);
}
