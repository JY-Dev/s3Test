package com.example.s3test.dto;

import com.example.s3test.domain.FileEntity;
import lombok.Getter;

@Getter
public class FileResponse {
    private String fileOwner;
    private String fileUrl;
    public FileResponse(FileEntity entity){
        this.fileOwner = entity.getOwner();
        this.fileUrl = entity.getFileUrl();
    }
}
