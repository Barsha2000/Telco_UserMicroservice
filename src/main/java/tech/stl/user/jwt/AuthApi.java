package tech.stl.user.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tech.stl.user.entity.User;
import tech.stl.user.repository.UserRepository;
import tech.stl.user.util.JwtTokenUtil;



@RestController
    public class AuthApi {
        @Autowired AuthenticationManager authManager;
        @Autowired JwtTokenUtil jwtUtil;
        
        @PostMapping("/auth/login")
        public ResponseEntity<?> login(@RequestBody AuthRequest request) {
            try {
                Authentication authentication = authManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                request.getEmail(), request.getPassword())
                );
                
                User user = (User) authentication.getPrincipal();
                String accessToken = jwtUtil.generateAccessToken(user);
                AuthResponse response = new AuthResponse(user.getEmail(), accessToken);
                
                return ResponseEntity.ok().body(response);
                
            } catch (BadCredentialsException ex) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
        }
        
        
        @Autowired UserRepository userRepo;
        @Autowired PasswordEncoder passwordEncoder;
        
        @PostMapping("/auth/signin/user")
        public User signin(@RequestBody User user) {
            //patient.addRole(new Role(1,"Patient"));
            String rawPassword = user.getPassword();
            String encodedPassword = passwordEncoder.encode(rawPassword);
            user.setPassword(encodedPassword);
            userRepo.save(user);
            return user;
        }

}