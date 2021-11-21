package com.example.makingboard.application.board.persistence;

import com.example.makingboard.application.board.persistence.entity.Poster;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PosterRepositoryTest {

    @Autowired
    private PosterRepository posterRepository;

    @After
    public void cleanUp() {
        posterRepository.deleteAll();
    }

    @Test
    public void save_posterSavePosterRepository_onePosterSavedPosterRepository() {
        posterRepository.save(Poster.builder()
                .title("TEST")
                .content("SUCCESS")
                .author("J")
                .build());

        List<Poster> posters = posterRepository.findAll();

        Poster testingPoster = posters.get(0);

        assertThat(testingPoster.getTitle()).isEqualTo("TEST");
        assertThat(testingPoster.getContent()).isEqualTo("SUCCESS");

        assertThat(testingPoster.getAuthor()).isEqualTo("J");

    }


}