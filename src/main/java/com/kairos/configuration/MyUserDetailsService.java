package com.kairos.configuration;

import com.kairos.entity.Student;
import com.kairos.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipal;
import java.util.List;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private StudentRepo studentRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Student student = studentRepo.findByName(username).orElseThrow(() -> {
            System.out.println("User not found");
           return new UsernameNotFoundException("User not found");
        });
//        if (student == null) {
//            throw new UsernameNotFoundException("User not found");
//        }

        return new MyUserPrinciple(student);
    }
}
