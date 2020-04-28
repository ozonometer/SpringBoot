package com.electronics.projects.service;

import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.Identity;
import com.google.cloud.Policy;
import com.google.cloud.storage.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import java.io.FileInputStream;
import java.io.IOException;


@Service
public class CloudStorageServiceImpl implements CloudStorageService {

    final String BUCKET_NAME = "diyprojectfiles";
    final String IMAGE = "image";
    final String FILE = "file";
    final String PROJECT_ID = "xenon-anvil-274300";
    final String BUCKET_HOME = "https://storage.googleapis.com/";
    final String API_KEY_PATH = "/etc/google/api_key2.json";

    /**
     * Method gets image and uploads it to specified google storage bucket
     * @param image Mulitpart image file received from frontend
     * @return String with bucket url
     */
    @Override
    public String uploadImage(MultipartFile image) throws ServletException, IOException {

        final String uploadPath = IMAGE + "/" + image.getOriginalFilename();
        final String uploadURL = BUCKET_HOME + BUCKET_NAME + "/" + uploadPath;

        checkFileExtension(image.getOriginalFilename());
        uploadToBucket(image, uploadPath);
        return uploadURL ;
    }

    /**
     * Method gets image and uploads it to specified google storage bucket
     * @param file Mulitpart file received from frontend
     * @return String with bucket url
     */
    @Override
    public String uploadFile(MultipartFile file) throws IOException {
        final String uploadPath = FILE + "/" + file.getOriginalFilename();
        final String uploadURL = BUCKET_HOME + BUCKET_NAME + "/" + uploadPath;

        uploadToBucket(file, uploadPath);
        return  uploadURL;
    }

    /**
     * Uploads file/image to Google bucket
     * @param file File send by front end
     * @param uploadPath Bucket upload path folder/file.extension
     */
    private void uploadToBucket(MultipartFile file, String uploadPath) throws IOException {
        Credentials credentials = GoogleCredentials.fromStream(new FileInputStream(API_KEY_PATH));
        Storage storage = StorageOptions.newBuilder().setCredentials(credentials).setProjectId(PROJECT_ID).build().getService();
        Policy originalPolicy = storage.getIamPolicy(BUCKET_NAME);
        storage.setIamPolicy(
                BUCKET_NAME,
                originalPolicy
                        .toBuilder()
                        .addIdentity(StorageRoles.objectViewer(), Identity.allUsers()) // All users can view
                        .build());

        BlobId blobId = BlobId.of(BUCKET_NAME, uploadPath);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).build();
        storage.create(blobInfo, file.getBytes());
    }

    private void checkFileExtension(String fileName) throws ServletException {
        if (fileName != null && !fileName.isEmpty() && fileName.contains(".")) {
            String[] allowedExt = {".jpg", ".jpeg", ".png", ".gif"};
            for (String ext : allowedExt) {
                if (fileName.endsWith(ext)) {
                    return;
                }
            }
            throw new ServletException("File must be an image");
        }
    }
}
