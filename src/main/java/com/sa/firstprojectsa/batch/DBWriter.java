package com.sa.firstprojectsa.batch;

import com.sa.firstprojectsa.model.Student;
import com.sa.firstprojectsa.repository.StudentRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class DBWriter implements ItemWriter<Student> {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public void write(List<? extends Student> list) throws Exception {
        studentRepository.saveAll(list);
    }
}
