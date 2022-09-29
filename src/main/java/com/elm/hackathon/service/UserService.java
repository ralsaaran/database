package com.elm.hackathon.service;

import com.elm.hackathon.dto.UserDto;
import com.elm.hackathon.model.User;
import com.elm.hackathon.model.enums.RoleEnum;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {

  User save(User user);

  void uploadUserImage(MultipartFile userImage, Long userId);

  byte[] getUserImage(String imageId);

  User findOne(Long id);

  User getUserByFirebaseId(String firebaseId);

  User update(UserDto userDto, Long userId);

  void updateUserRole(Long id, RoleEnum role);
}
