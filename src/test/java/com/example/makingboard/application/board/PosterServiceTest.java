package com.example.makingboard.application.board;

import com.example.makingboard.application.board.dto.PosterRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PosterServiceTest {
    @Autowired
    private PosterService posterService;
    @Test
    public void createPost() {
        for(int i = 0; i < 100; i++) {
            PosterRequest request = new PosterRequest(i + "TEST" + i, i + "TEST" + i, i + "TEST" + i);
            posterService.savePoster(request);
        }
    }
}