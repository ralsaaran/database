package com.elm.hackathon.controller;

import com.elm.hackathon.service.UserService;
import com.elm.hackathon.dto.UserDto;
import com.elm.hackathon.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

  @Autowired
  UserService userService;

  @PostMapping
  public ResponseEntity<User> createUser(@RequestBody User user) {
    User body = userService.save(user);
    return ResponseEntity.ok(body);
  }

  @PostMapping(value = "/image/{id}", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
  public void uploadUserImage(@PathVariable Long id,
                                                @RequestPart MultipartFile userImage) {
    userService.uploadUserImage(userImage, id);
  }

  @PutMapping("/{id}")
  public ResponseEntity<User> updateUser(@PathVariable Long id,
                                         @RequestBody UserDto userDto) {
    User body = userService.update(userDto, id);
    return ResponseEntity.ok(body);
  }

  @GetMapping("/{firebaseId}")
  public ResponseEntity<User> getUser(@PathVariable String firebaseId) {
    User body = userService.getUserByFirebaseId(firebaseId);
    return ResponseEntity.ok(body);
  }

  @GetMapping("/image")
  public ResponseEntity<byte[]> userImage(@RequestParam String imageId) {
    byte[] body = userService.getUserImage(imageId);
    return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(body);
  }
}
