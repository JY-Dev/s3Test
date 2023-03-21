package com.example.s3test.dto;

import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

@Getter
public class FileUploadRequest {
    private String owner;
    private MultipartFile file;
}
