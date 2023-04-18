package com.ise.springjpasample;

import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
public class UserController {
    UserRepository userRepository;
    Logger log = LoggerFactory.getLogger(UserController.class);

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/hello")
    public void hello() {
        log.info("helloの実施");
        System.out.println(userRepository.findAll());
    }

    @GetMapping("/save/{name}")
    public void save(@PathVariable("name") String name){
        UserEntity user = new UserEntity();
        user.setName(name);
        userRepository.save(user);
    }

    @GetMapping("{id}")
    public List<UserEntity> findById(@PathVariable("id") String id){
        return userRepository.findByName(id);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable("id") String id){
        userRepository.deleteById(id);
    }

    @GetMapping("exist/{id}")
    public boolean existById(@PathVariable("id") String id){
        return userRepository.existsById(id);

    }

}
