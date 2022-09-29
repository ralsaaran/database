package com.elm.hackathon.service.impl;

import com.elm.hackathon.model.enums.Role;
import com.elm.hackathon.service.ProfileImageService;
import com.elm.hackathon.service.UserService;
import com.elm.hackathon.dto.UserDto;
import com.elm.hackathon.exception.RecordNotFoundException;
import com.elm.hackathon.model.User;
import com.elm.hackathon.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UserServiceImpl implements UserService {

  private static final String USER_PREFIX = "user-";

  UserRepository userRepository;


  ProfileImageService profileImageService;

  public UserServiceImpl(UserRepository userRepository, ProfileImageService profileImageService) {
    this.userRepository = userRepository;
    this.profileImageService = profileImageService;
  }

  @Override
  public User save(User user) {
    return userRepository.save(user);
  }

  @Override
  public byte[] getUserImage(String imageId) {
    return profileImageService.getImage(imageId, USER_PREFIX);
  }

  @Override
  public User findOne(String id) {
    return userRepository.findById(id)
        .orElseThrow(() -> new RecordNotFoundException("User Not Found"));
  }

  @Override
  public User getUserByFirebaseId(String firebaseId) {
    return userRepository.findByFirebaseId(firebaseId)
        .orElseThrow(() -> new RecordNotFoundException("User Not Found"));
  }

  @Override
  public User update(UserDto userDto, String id) {
    User user = findOne(id);

    user.setUsername(userDto.getUsername());
    user.setPhoneNumber(userDto.getPhoneNumber());
    user.setAge(userDto.getAge());
    user.setCity(userDto.getCity());
    user.setGender(userDto.getGender());
    return userRepository.save(user);
  }

  @Override
  public void uploadUserImage(MultipartFile userImage, String userId) {
    profileImageService.uploadImage(userImage, userId, USER_PREFIX);
  }

  @Override
  public void updateUserRole(String id, Role role) {
    User updateMembership = findOne(id);
    updateMembership.addRole(role);
    userRepository.save(updateMembership);
  }
}
