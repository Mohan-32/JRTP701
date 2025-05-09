package com.example.service;

import java.sql.Date;
import java.util.Map;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class BenefitInsuranceMgmt implements IBenefirInssuanceService {
	@Autowired
	private JobLauncher launcher;
    @Autowired
    private Job job;
    

	@Override
	public JobExecution sendAmountToBeneficiries() throws Exception {
		JobParameter<Date> param = new JobParameter<Date>(new Date(0), Date.class);
		Map<String, JobParameter<?>> map= Map.of("param1",param);
		JobParameters params= new JobParameters(map);
		JobExecution execution = launcher.run(job, params);
		System.out.println("job execution Status::"+execution.getExitStatus());
		return execution;
		
		
		
	}

}
