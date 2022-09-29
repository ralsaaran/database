package com.elm.hackathon.service;

import org.springframework.web.multipart.MultipartFile;

public interface ProfileImageService {
    void uploadImage(MultipartFile image, String id, String prefix);
    byte[] getImage(String id, String prefix);


    }
