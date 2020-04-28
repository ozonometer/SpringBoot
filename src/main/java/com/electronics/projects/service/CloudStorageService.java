package com.electronics.projects.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import java.io.IOException;

public interface CloudStorageService {

    String uploadImage(MultipartFile image) throws ServletException, IOException;

    String uploadFile(MultipartFile file) throws IOException;
}
