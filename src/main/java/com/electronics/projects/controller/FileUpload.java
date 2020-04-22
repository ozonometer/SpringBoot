package com.electronics.projects.controller;

import com.electronics.projects.service.CloudStorageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.HashMap;


@Controller
@RequestMapping("/upload")
public class FileUpload {

    final
    CloudStorageService cloudStorageService;

    public FileUpload(CloudStorageService cloudStorageService) {
        this.cloudStorageService = cloudStorageService;
    }

    @PostMapping("/image")
    public ResponseEntity<HashMap<String, String>> uploadImage(@RequestParam("image") MultipartFile image) throws ServletException, IOException {

        HashMap<String, String> response = new HashMap<>();
        String uploadURL = cloudStorageService.uploadImage(image);

        response.put("url", uploadURL);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}

