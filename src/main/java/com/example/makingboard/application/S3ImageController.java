package com.example.makingboard.application;

import com.example.makingboard.application.board.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
public class S3ImageController {

    private final S3Service s3Service;

    @PostMapping("/api/v1/upload/image")
    public String uploadImage(@RequestPart(value = "image") MultipartFile image) throws IOException {
        return s3Service.uploadImage(image);
    }
}
