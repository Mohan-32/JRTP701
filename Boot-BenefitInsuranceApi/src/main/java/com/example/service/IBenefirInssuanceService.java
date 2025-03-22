package com.example.service;

import org.springframework.batch.core.JobExecution;

public interface IBenefirInssuanceService {
	
	public JobExecution sendAmountToBeneficiries()throws Exception;

}
