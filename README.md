# Speech-to-Text (Spring Boot + AssemblyAI)
A convenient application for automatic transcription of media files. You can upload a video, and the application will create a text transcript using the AssemblyAI API. You can view, edit the resulting text, and download the result in popular formats: as a text file (TXT), for subtitles (SRT), or structured JSON.
## Prerequisites
```
Java 17+
Maven 3.8+
AssemblyAI API key 
```
You can get the [AssemblyAI API key](https://www.assemblyai.com) on their official website

## Configure API key
Open /audioProccesing.java and set your key:
```
AssemblyAI aai = AssemblyAI.builder()    
  .apiKey("YOUR_API_KEY_HERE")    
  .build();
```

## Install & run
* You need download the latest version in releases or clone from github
* The app serves at http://localhost:8080/main (default Spring Boot port)

## File upload limits
Already configured in application.properties (adjust if needed):
```
  spring.servlet.multipart.max-file-size=500MB
  spring.servlet.multipart.max-request-size=500MB
  server.tomcat.max-swallow-size=-1
  server.tomcat.max-http-form-post-size=500MB
```
Usage
1) Open http://localhost:8080/main
2) Drag & drop or choose a video (MP4/AVI/MOV/MKV)
3) Wait for processing; transcript appears in the text panel
4) Edit/copy the text or download as TXT/JSON/SRT
