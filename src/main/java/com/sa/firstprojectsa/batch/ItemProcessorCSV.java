package com.sa.firstprojectsa.batch;

import com.sa.firstprojectsa.model.Student;
import com.sa.firstprojectsa.repository.StudentRepository;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ItemProcessorCSV implements ItemProcessor<StudentCSV, Student> {


    @Override
    public Student process(StudentCSV studentCSV) throws Exception {
        LocalDate firstDayOfYear =LocalDate.of(LocalDate.now().getYear(),1,1);
        LocalDate dob = firstDayOfYear.minusYears(studentCSV.getAge());
        Student student=new Student();
        student.setDob(dob);
        student.setFirst(studentCSV.getFirst());
        student.setLast(studentCSV.getLast());
        student.setGpa(studentCSV.getGpa());
        student.setId(studentCSV.getId());

        return student;
    }
}
