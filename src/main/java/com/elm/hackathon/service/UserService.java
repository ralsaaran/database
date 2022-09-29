package com.elm.hackathon.service;

import com.elm.hackathon.dto.UserDto;
import com.elm.hackathon.model.User;
import com.elm.hackathon.model.enums.Role;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {

  User save(User user);

  void uploadUserImage(MultipartFile userImage, String userId);

  byte[] getUserImage(String imageId);

  User findOne(String id);

  User getUserByFirebaseId(String firebaseId);

  User update(UserDto userDto, String email);

  void updateUserRole(String id, Role role);
}
