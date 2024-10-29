package com.kairos.runner;

import com.kairos.entity.Student;
import com.kairos.repo.StudentRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements ApplicationRunner {
    @Autowired
    private StudentRepo studentRepo;

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        saveStudent();
//        findByName("Raju", 1L);
    }


//    @Transactional
    void findByName(String name, Long id){
        studentRepo.updateName(name, id);
    }

    void saveStudent() {
        Student s = new Student();
        s.setName("Bachi");
        studentRepo.save(s);
    }
}
