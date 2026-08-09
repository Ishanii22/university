package com.example.demo;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/university")
@RequiredArgsConstructor
public class UniversityController {

    private final UniversityService universityService;

    @PostMapping
    public ResponseEntity<University> create(@RequestBody University university) {
        University saved = universityService.save(university);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<University>> getAll() {
        return ResponseEntity.ok(universityService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<University> getById(@PathVariable String id) {
        return ResponseEntity.ok(universityService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<University> update(@PathVariable String id, @RequestBody University university) {
        return ResponseEntity.ok(universityService.update(id, university));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        universityService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
