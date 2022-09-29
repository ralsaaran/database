package com.elm.hackathon.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;
import com.elm.hackathon.service.ProfileImageService;
import org.apache.http.entity.ContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ProfileImageServiceImpl implements ProfileImageService {

  private Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

  @Value("${application.bucket.name}")
  private String bucketName;

  @Autowired
  private AmazonS3 s3Client;

  @Override
  public void uploadImage(MultipartFile image, String id, String prefix) {
    if (!Arrays.asList(ContentType.IMAGE_JPEG.getMimeType(), ContentType.IMAGE_PNG.getMimeType(),
        ContentType.IMAGE_GIF.getMimeType()).contains(image.getContentType())) {
      throw new IllegalStateException("File must be an Image");
    }
    File fileObj = convertMultiPartFileToFile(image);
    String imageId = prefix + id;
    s3Client.putObject(new PutObjectRequest(bucketName, imageId, fileObj));
    fileObj.delete();
  }

  @Override
  public byte[] getImage(String id, String prefix) {
    String imageId = prefix + id;
    S3Object s3Object = s3Client.getObject(bucketName, imageId);
    S3ObjectInputStream inputStream = s3Object.getObjectContent();
    try {
      return IOUtils.toByteArray(inputStream);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  private File convertMultiPartFileToFile(MultipartFile file) {
    File convertedFile = new File(file.getOriginalFilename());
    try (FileOutputStream fos = new FileOutputStream(convertedFile)) {
      fos.write(file.getBytes());
    } catch (IOException e) {
      log.error("Error converting multipartFile to file", e);
    }
    return convertedFile;
  }
}
