package com.example.demo;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.http.ResponseEntity;import org.springframework.web.bind.annotation.GetMapping;import org.springframework.web.bind.annotation.PathVariable;import org.springframework.web.bind.annotation.RequestMapping;import org.springframework.web.bind.annotation.RestController;import java.net.URI;import java.util.List;@RestController@RequestMapping("/api/users")public class UserController {        @Autowired    private UserRepository userRepository;        // Fetch all users    @GetMapping    public List<User> getAllUsers() {        return userRepository.findAll();    }        // Fetch a specific user by ID    @GetMapping("/{id}")    public ResponseEntity<com.example.demo.User> getUserById(@PathVariable Long id) {        return userRepository.findById(id)                .map(ResponseEntity::ok)                .orElse(ResponseEntity.notFound().build());    }        @GetMapping("/name/{name}")    public ResponseEntity<com.example.demo.User> getUserByName(@PathVariable String name) {        return userRepository.findByName(name)                .map(ResponseEntity::ok)                .orElse(ResponseEntity.notFound().build());    }        @GetMapping("/email/{email}")    public ResponseEntity<com.example.demo.User> getUserbyEmail(@PathVariable String email) {        return userRepository.findByEmail(email)                .map(ResponseEntity::ok)                .orElse(ResponseEntity.notFound().build());    }    }