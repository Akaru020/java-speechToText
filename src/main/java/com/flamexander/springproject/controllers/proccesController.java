package com.flamexander.springproject.controllers;
import com.flamexander.springproject.model.FileDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@RestController

public class proccesController {
    FileDTO fileDTO = new FileDTO();
    private audioProccesing audioProccesing = new audioProccesing();

    @PostMapping("/api/process")
    public FileDTO FileReceiver(@RequestPart("video") MultipartFile file) throws IOException {
        fileDTO.setFileName(file.getOriginalFilename());

        String extractedText = audioProccesing.AuidoProccesing(file);
        fileDTO.setExtractedText(extractedText);

        fileDTO.setSizeMb(Math.round(
                file.getSize() / (1024.0 * 1024.0)
                        * 100.0) / 100.0f);

        long wordCount = extractedText.trim().isEmpty() ? 0 :
                extractedText.trim().split("\\s+").length;
        fileDTO.setWordCount(wordCount);

        System.out.println("File features:" + "\n" +
                "Name: " + file.getOriginalFilename() + "\n" +
                "Size: " + file.getSize() + "\n" +
                "Type: " + file.getContentType() + "\n"
        );

        return fileDTO;
    }
}
