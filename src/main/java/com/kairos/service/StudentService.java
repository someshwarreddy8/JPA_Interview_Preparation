package com.kairos.service;

import com.kairos.entity.Address;
import com.kairos.entity.Student;
import com.kairos.repo.AddressRepo;
import com.kairos.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService {
    private final PasswordEncoder encoder = new BCryptPasswordEncoder(12);
    @Autowired
    private StudentRepo repo;
    @Autowired
    private AddressRepo addressRepo;
    @Autowired
    private AuthenticationManager manager;

    public List<Student> getStudents() {

//        if (studentList.get(0).getId() == 1L)
//            throw new StudentException("111", new NullPointerException());
        return repo.findAll();
    }

    @Transactional
    public Student saveStudent(Student student) {
        Student s = new Student();

        Address a = new Address();
        a.setArea("HYD");
        a.setStudent(s);

        s.setName("Raju");
        s.addAddress(a);


        Student savedStudent = repo.save(student);

//        if (!ObjectUtils.isEmpty(savedStudent))
//            throw new RuntimeException();

        student.setPassword(encoder.encode(student.getPassword()));
//        Address savedAddress = addressRepo.save(a);

//        student.setId(savedStudent.getId());
//        student.setAddress(savedStudent.getAddress());
//        student.addAddress(savedAddress);

        return savedStudent;


    }

    public List<Address> getAddress() {
        return addressRepo.findAll();
    }

    public String verify(Student student) {
        Authentication authenticate = manager.authenticate(new UsernamePasswordAuthenticationToken(student.getName(), student.getPassword()));
        if (authenticate.isAuthenticated())
            return "success";
        return "fail";
    }
}
