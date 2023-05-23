package org.example.dao;

import org.example.entities.Students;
import org.springframework.orm.hibernate5.HibernateTemplate;

import javax.transaction.Transactional;
import java.util.List;

public class StudentDaoImpl implements StudentDao{
    private HibernateTemplate hibernateTemplate;
    @Override
    @Transactional
    public int insert(Students students) {
        int i=(int) this.hibernateTemplate.save(students);
        return i;
    }
    @Override
    @Transactional
    public void update(Students students) {
        this.hibernateTemplate.update(students);
    }

    @Override
    public Students getStudent(int id) {
        return this.hibernateTemplate.get(Students.class,id);
    }

    @Override
    public List<Students> getAllStudent() {
        return this.hibernateTemplate.loadAll(Students.class);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Students student = this.hibernateTemplate.get(Students.class,id);
        this.hibernateTemplate.delete(student);
    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}
