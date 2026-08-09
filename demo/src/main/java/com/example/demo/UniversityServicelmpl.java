package com.example.demo;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UniversityServicelmpl implements UniversityService {

    private final UniversityRepository universityRepository;

    @Override
    public University save(University university) {
        return universityRepository.save(university);
    }

    @Override
    public List<University> getAll() {
        return universityRepository.findAll();
    }

    @Override
    public University getById(String id) {
        return universityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
    }

    @Override
    public University update(String id, University university) {
        University existing = getById(id);
        existing.setName(university.getName());
        existing.setEmail(university.getEmail());
        existing.setAge(university.getAge());
        return universityRepository.save(existing);
    }

    @Override
    public void delete(String id) {
        universityRepository.deleteById(id);
    }
}
