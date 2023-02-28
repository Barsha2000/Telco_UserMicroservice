package tech.stl.user.jwt;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import tech.stl.user.entity.User;
import tech.stl.user.repository.UserRepository;

@RestController
public class UserApi {
@Autowired private UserRepository service;
    
    @PutMapping("/users")
    public ResponseEntity<?> createUser(@RequestBody @Valid User user) {
        User createdUser = service.save(user);
        URI uri = URI.create("/users/" + createdUser.getUserId());
        
        UserDto userDto = new UserDto(createdUser.getUserId(), createdUser.getEmail());
        
        return ResponseEntity.created(uri).body(userDto);
    }

}
