package com.flamexander.springproject.model;
import lombok.Data;

@Data
public class FileDTO {
    String fileName;
    float sizeMb;
    String extractedText;
    long wordCount;

}
