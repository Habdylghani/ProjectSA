package com.sa.firstprojectsa.config;

import com.sa.firstprojectsa.batch.StudentCSV;
import com.sa.firstprojectsa.model.Student;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {
    @Bean
    public Job job(JobBuilderFactory jobBuilderFactory,
                   StepBuilderFactory stepBuilderFactory,
                   ItemReader<StudentCSV> itemReader,
                   ItemProcessor<StudentCSV,Student> itemProcessor,
                   ItemWriter<Student> itemWriter
    ){

        Step step=stepBuilderFactory.get("ETL-file-load")
                .<StudentCSV,Student>chunk(100)
                .reader(itemReader)
                .processor(itemProcessor)
                .writer(itemWriter)
                .build();
        Job job=jobBuilderFactory.get("ETL-Load")
                .incrementer(new RunIdIncrementer())
                .start(step)
                .build();
        return job;
    }

    @Bean
    public FlatFileItemReader<StudentCSV> fileItemReader(@Value("${input}") Resource resource){
        FlatFileItemReader<StudentCSV> flatfileItemReader=new FlatFileItemReader<>();
        flatfileItemReader.setResource(new FileSystemResource("src/main/resources/students.csv"));
        flatfileItemReader.setName("csv-reader");
        flatfileItemReader.setLinesToSkip(1);
        flatfileItemReader.setLineMapper(lineMapper());
        return flatfileItemReader;
    }
    @Bean
    public LineMapper<StudentCSV> lineMapper(){
        DefaultLineMapper<StudentCSV> defaultLineMapper=new DefaultLineMapper<>();
        DelimitedLineTokenizer lineTokenizer=new DelimitedLineTokenizer();

        lineTokenizer.setDelimiter(",");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames("id","first","last","gpa","age");

        BeanWrapperFieldSetMapper<StudentCSV> fieldSetMapper=new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(StudentCSV.class);

        defaultLineMapper.setLineTokenizer(lineTokenizer);
        defaultLineMapper.setFieldSetMapper(fieldSetMapper);
        return defaultLineMapper;
    }
}
