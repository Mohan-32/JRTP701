package com.example.config;

import java.util.Map;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.batch.BatchProperties.Job;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.PlatformTransactionManager;

import com.example.binding.EligibilityDeterminationBinding;
import com.example.entity.EligibilityDeterminationEntity;
import com.example.processor.EDDetailsProcessor;
import com.example.repo.IEligibilityRepo;

@Configuration
public class BatchConfig {

	
	@Autowired
	private IEligibilityRepo eligiRepo;
	@Autowired
	private EDDetailsProcessor processor;
	
	@Bean(name = "reader")
	public RepositoryItemReader<EligibilityDeterminationEntity> createReader() {
	    RepositoryItemReader<EligibilityDeterminationEntity> reader = new RepositoryItemReader<>();
	    
	    reader.setName("repo-reader");
	    reader.setRepository(eligiRepo);  // This should be an injected repository (likely an interface extending JpaRepository)
	    reader.setMethodName("findAll");
	    
	    // Sorting criteria - ascending order by caseNo
	    reader.setSort(Map.of("caseNo", Sort.Direction.ASC));

	    // Build the reader
	    return reader;
	}

	@Bean(name="writer")
	public FlatFileItemWriter<EligibilityDeterminationBinding> createWriter(){
		 FlatFileItemWriter<EligibilityDeterminationBinding> writer = new FlatFileItemWriter<>();
		    
		    writer.setName("file-writer");
		    writer.setResource(new FileSystemResource("beneficiaries.csv"));
		    writer.setLineSeparator("\r\n");
		    writer.setLineAggregator(new DelimitedLineAggregator<EligibilityDeterminationBinding>() {{
		        setDelimiter(",");
		        setFieldExtractor(new BeanWrapperFieldExtractor<EligibilityDeterminationBinding>() {{
		            setNames(new String[] {"caseNo", "holderName", "holderSSn", "benfamt", "accNumber", "bankName"});
		        }});
		    }});

		    return writer;
	}
	@Bean(name="step1")
	public Step createStep(JobRepository jobRepository, PlatformTransactionManager manager) {
		return new StepBuilder("step1",jobRepository)
				.<EligibilityDeterminationEntity,EligibilityDeterminationBinding >chunk(3,manager)
				.reader(createReader())
		.processor(processor)
		.writer(createWriter())
		.build();
	}
	@Bean(name="job1")
	public Job createJob(JobRepository jobRepository, Step step1) {
		return new JobBuilder("job1",jobRepository)
				.incrementer(new RunIdIncrementer())
				.start(step1)
				.build();
	}
	
}
