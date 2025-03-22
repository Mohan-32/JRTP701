package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.entity.CitizenApplicationEntity;
import com.example.entity.DcCaseEntity;
import com.example.repo.CitizenApplicationRepo;
import com.example.repo.IDcCaseRepository;
import com.example.repo.IDcChildrenRepository;
import com.example.repo.IDcEducationRepository;
import com.example.repo.IDcIncomeRepository;
import com.example.repo.IPlanRepository;
import com.example.service.DcServicemgmt;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class DcMgmtServiceImplTest {
	@MockBean
	private IDcCaseRepository caseRepo;
	@MockBean
	private CitizenApplicationRepo citizenRepo;
	@MockBean
	private IPlanRepository planRepo;
	@MockBean
	private IDcIncomeRepository incRepo;
	@MockBean
	private IDcEducationRepository eduRepo;
	@MockBean
	private IDcChildrenRepository childRepo;
	
	@InjectMocks
	private DcServicemgmt dcService;
	
	
	@Test
	public void generateCaseNOtest1() {
		CitizenApplicationEntity citizenEntity = new CitizenApplicationEntity();
		citizenEntity.setAppId(1);
		Optional<CitizenApplicationEntity> optEntity = Optional.of(citizenEntity);
		Mockito.when(citizenRepo.findById(1)).thenReturn(optEntity);
		DcCaseEntity dcEntity = new DcCaseEntity();
		dcEntity.setAppid(1);
		DcCaseEntity dcEntity1 = new DcCaseEntity();
		dcEntity1.setAppid(1);
		dcEntity1.setCaseNo(1001);
		Mockito.when(caseRepo.save(dcEntity)).thenReturn(dcEntity1);
		int actual = dcService.generateCaseNo(1);
		assertEquals(1001, actual);
		
		
	}
	

}
