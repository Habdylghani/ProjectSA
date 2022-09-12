package com.sa.firstprojectsa.commandRunner;

import com.sa.firstprojectsa.model.Role;
import com.sa.firstprojectsa.model.User;
import com.sa.firstprojectsa.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class CommandRunner  implements CommandLineRunner {
    private UserService userRepo;
    @Override
    public void run(String... args) throws Exception {
        User user=new User(0,"abdel","abdel","000",new ArrayList<>());
        Role role_student=new Role(0,"student",null);
        Role role_admin=new Role(0,"admin",null);

        role_student.setUser(user);
        role_admin.setUser(user);
        System.out.println("here are the entities");
        user.setRoles(Arrays.asList(role_student,role_admin));
        userRepo.addUser(user);
    }
}
