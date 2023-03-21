package com.example.s3test.domain;

import com.example.s3test.dto.FileRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
public class FileEntity extends BaseEntity{
    @Id
    @GeneratedValue
    private Long id;
    private String owner;
    private String fileUrl;

    public FileEntity(FileRequest request){
        this.owner = request.getFileOwner();
        this.fileUrl = request.getFileUrl();
    }
}
