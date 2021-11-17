package com.example.makingboard.application;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

@RequiredArgsConstructor
@RestController
public class S3ImageController {

    @Autowired
    private final AmazonS3 s3Client;

    @Value("${cloud.aws.s3.bucket}")
    private String bucketName;


    @Value("${cloud.aws.region.static}")
    private String region;

    public File convert(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        convFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }

    @PostMapping("/api/v1/upload/image")
    public String uploadImage(@RequestPart("file")MultipartFile multipartFile, HttpServletRequest request) throws Exception {
        try {
            String fName = multipartFile.getOriginalFilename();
            System.out.println(fName.indexOf("."));
            if (fName.indexOf(".") != -1) {
                String ext = fName.split("\\.")[1];
                PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, UUID.randomUUID() + "." + ext, convert(multipartFile));
                putObjectRequest.setCannedAcl(CannedAccessControlList.PublicRead);
                s3Client.putObject(putObjectRequest);
            }
        } catch (AmazonServiceException e) {

        } catch (AmazonClientException ace) {

        }return "ApiResponse.success";
    }

    @GetMapping("/api/v1/download/image")
    public String fileDownloadList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ObjectListing objectListing = s3Client.listObjects(bucketName);
        List<String> arrayKeyList = new ArrayList<>();
        List<Date> arrayModTimeList = new ArrayList<>();
        for (S3ObjectSummary s : objectListing.getObjectSummaries()) {
            arrayKeyList.add(s.getKey());
            arrayModTimeList.add(s.getLastModified());
        }
        Date max = Collections.max(arrayModTimeList);
        String fileName = arrayKeyList.get(arrayModTimeList.indexOf(max));
        String url = "https://" + bucketName + ".s3" + region + ".amazonaws.com/" + fileName;
        return url;
    }
}
