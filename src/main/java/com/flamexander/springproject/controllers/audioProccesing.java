package com.flamexander.springproject.controllers;
import com.assemblyai.api.AssemblyAI;
import com.assemblyai.api.resources.transcripts.types.Transcript;
import com.assemblyai.api.resources.transcripts.types.TranscriptOptionalParams;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;


public class audioProccesing {

    AssemblyAI aai = AssemblyAI.builder()
            .apiKey("YOUR_API_KEY_HERE")
            .build();

    String text;

    public String AuidoProccesing(MultipartFile file) throws IOException {

        Transcript transcript = aai.transcripts().transcribe(
                file.getInputStream(),
                TranscriptOptionalParams.builder().languageDetection(true).build());

        System.out.println("Extracted text: " + transcript.getText().orElse("") + "\n");
        text = transcript.getText().orElse("");

        return text;

    }
}
