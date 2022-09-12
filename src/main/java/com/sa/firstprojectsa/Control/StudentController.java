package com.sa.firstprojectsa.Control;

import com.sa.firstprojectsa.model.User;
import com.sa.firstprojectsa.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Slf4j @RequiredArgsConstructor
public class StudentController {
    private JobLauncher launcher;
    private Job job;
    private UserService userService;
    @GetMapping("/add")
    public void maigrate(){
        JobParameters jobParameters=new JobParametersBuilder()
                .addLong("startAt",System.currentTimeMillis()).toJobParameters();
        try {
            launcher.run(job,jobParameters);
        }catch (JobExecutionAlreadyRunningException | JobInstanceAlreadyCompleteException | JobRestartException |
                JobParametersInvalidException e) {
            e.printStackTrace();
        }
    }
    @PostMapping("/user/save/adduser")
    public User saveUser(@RequestBody User user){
        return userService.addUser(user);
    }

}
