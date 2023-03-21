package com.example.s3test;

import com.example.s3test.domain.FileEntity;
import com.example.s3test.dto.FileRequest;
import com.example.s3test.dto.FileResponse;
import com.example.s3test.repository.FileRepository;
import com.example.s3test.repository.S3BucketManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RequiredArgsConstructor
@Transactional
@Service
public class FileService {
    private final FileRepository repository;
    private final S3BucketManager s3BucketManager;
    public FileResponse saveFile(String fileOwner , MultipartFile multipartFile){
        String fileUrl = s3BucketManager.upload(fileOwner, multipartFile);
        FileRequest fileRequest = FileRequest.builder()
                .fileUrl(fileUrl)
                .fileOwner(fileOwner)
                .build();
        FileEntity fileEntity = new FileEntity(fileRequest);
        FileEntity result = repository.save(fileEntity);
        return new FileResponse(result);
    }
}
