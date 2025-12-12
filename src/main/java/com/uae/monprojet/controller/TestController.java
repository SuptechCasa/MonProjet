package com.uae.monprojet.controller;

import com.uae.monprojet.model.Employe;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class TestController {
    @GetMapping("hello")
    public String sayHello() {
        return "Hello World";
    }

    @GetMapping("bonjour")
    public ResponseEntity<String> bonjour1(@RequestParam String nom) {
        return ResponseEntity.ok("bonjour "+nom);
    }
    @GetMapping("bonjour/{nom}")
    public ResponseEntity<String> bonjour2(@PathVariable String nom) {
        return ResponseEntity.ok("bonjour "+nom);
    }
    @GetMapping("headers")
    public ResponseEntity<String> headers(@RequestHeader(value = "sec-ch-ua") String navigator) {
        return ResponseEntity.ok("l'OS est :"+navigator);
    }

    @PostMapping("employe")
    public ResponseEntity<Employe> employe(@RequestBody Employe employe) {
        employe.setAge(43);
        return ResponseEntity.ok(employe);
    }

    @PostMapping("upload")
    public ResponseEntity<String> uploadImage(@RequestParam("photo") MultipartFile photo) throws IOException {
        String path="src/main/resources/static/photos/"+photo.getOriginalFilename();
        photo.transferTo(Path.of(path));

        return ResponseEntity.ok("Image uploaded: "+photo.getOriginalFilename());
    }

    @PostMapping("employecomplet")
    public ResponseEntity<Employe> employecomplet(
            @RequestParam Long id,
            @RequestParam String nom,
            @RequestParam int age,
            @RequestParam("photo") MultipartFile photo
    ) {
        //Employe employe = new Employe(id, nom, age,"http://localhost:8080/photos/"+photo.getOriginalFilename());
        Employe employe=new Employe();
        employe.setId(id);employe.setNom(nom);employe.setAge(age);
        employe.setPhoto("http://localhost:8080/photos/"+photo.getOriginalFilename());
        return ResponseEntity.ok(employe);
    }

    @PostMapping("fullemploye")
    public ResponseEntity<Employe> fullemploye(
            @RequestPart("employe") String employejson,
            @RequestPart("photo") MultipartFile photo
    ) throws IOException {
        String path="src/main/resources/static/photos/"+photo.getOriginalFilename();
        photo.transferTo(Path.of(path));
        ObjectMapper mapper = new ObjectMapper();
        Employe employe= mapper.readValue(employejson,Employe.class);
        employe.setPhoto("http://localhost:8080/photos/"+photo.getOriginalFilename());
        return ResponseEntity.ok(employe);

    }

}
