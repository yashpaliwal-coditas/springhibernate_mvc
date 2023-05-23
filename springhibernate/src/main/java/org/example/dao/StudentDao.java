package org.example.dao;

import org.example.entities.Students;

import java.util.List;

public interface StudentDao {
    public int insert(Students students);
    public void update(Students students);
    public Students getStudent(int id);
    public List<Students> getAllStudent();
    public void delete(int id);
}
