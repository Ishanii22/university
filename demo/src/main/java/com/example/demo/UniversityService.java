package com.example.demo;

import java.util.List;

public interface UniversityService {
    University save(University student);
    List<University> getAll();
    University getById(String id);
    University update(String id, University student);
    void delete(String id);
}
