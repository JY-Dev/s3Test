package com.example.s3test;

import com.example.s3test.dto.FileResponse;
import com.example.s3test.dto.FileUploadRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RequiredArgsConstructor
@RestController
public class FileController {
    private final FileService fileService;

    @PostMapping("/upload/file")
    private ResponseEntity<FileResponse> fileUpload(@RequestPart String owner, @RequestPart MultipartFile file){
        FileResponse fileResponse = fileService.saveFile(owner, file);
        return ResponseEntity.ok(fileResponse);
    }
}
