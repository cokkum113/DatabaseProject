package com.example.makingboard.application.board.persistence;

import com.example.makingboard.application.board.persistence.entity.Poster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PosterRepository extends JpaRepository<Poster, Long> {
}
