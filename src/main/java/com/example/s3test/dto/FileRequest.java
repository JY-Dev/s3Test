package com.example.s3test.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FileRequest {
    private String fileOwner;
    private String fileUrl;
}
