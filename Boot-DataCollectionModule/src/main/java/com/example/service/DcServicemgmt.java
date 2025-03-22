package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bindingd.ChildInputs;
import com.example.bindingd.CitizenAppRegistrationInputs;
import com.example.bindingd.DcSummaryReport;
import com.example.bindingd.EducationInputs;
import com.example.bindingd.IncomeInputs;
import com.example.bindingd.PlanSelectionInputs;
import com.example.entity.CitizenApplicationEntity;
import com.example.entity.DcCaseEntity;
import com.example.entity.DcChildrenEntity;
import com.example.entity.DcEducationEntity;
import com.example.entity.DcIncomeEntity;
import com.example.entity.PlanEntity;
import com.example.repo.CitizenApplicationRepo;
import com.example.repo.IDcCaseRepository;
import com.example.repo.IDcChildrenRepository;
import com.example.repo.IDcEducationRepository;
import com.example.repo.IDcIncomeRepository;
import com.example.repo.IPlanRepository;


@Service
public class DcServicemgmt implements IDCMgmtService {
	
	@Autowired
	private IDcCaseRepository caseRepo;
	@Autowired
	private CitizenApplicationRepo citizenRepo;
	@Autowired
	private IPlanRepository planRepo;
	@Autowired
	private IDcIncomeRepository incRepo;
	@Autowired
	private IDcEducationRepository eduRepo;
	@Autowired
	private IDcChildrenRepository childRepo;
	
	
	

	@Override
	public Integer generateCaseNo(Integer appid) {
		
		 Optional<CitizenApplicationEntity> opt=  citizenRepo.findById(appid);
		 if(opt.isPresent()) {
			 /*CitizenApplicationEntity entity = opt.get();*/
			 DcCaseEntity entity = new DcCaseEntity();
			 entity.setAppid(appid);
			return  caseRepo.save(entity).getCaseNo();
			 
			 
			 
		 }
		
		
		
		
		return 0;
	}

	@Override
	public List<String> showAllPlanNames() {
		 List<PlanEntity> planList = planRepo.findAll();
		 
		 List<String> planNames = planList.stream().map(plan -> plan.getPlanName()).toList(); ;
				 
		return planNames;
	}
	

	@Override
	public Integer savePlanSelection(PlanSelectionInputs inputs) {
		
		  Optional<DcCaseEntity> opt =caseRepo.findById(inputs.getCaseNo());
		  if(opt.isPresent()) {
		    DcCaseEntity entity = opt.get();
		    entity.setPlanid(inputs.getPlanId());
		    caseRepo.save(entity);
		    return entity.getCaseNo();
		  }   
		
		return 0;
	}

	@Override
	public Integer saveIncomeDetails(IncomeInputs inputs) {
		
		DcIncomeEntity entity = new DcIncomeEntity();
		BeanUtils.copyProperties(inputs, entity);
		incRepo.save(entity);
		
		
		return entity.getCaseNo();
	}

	@Override
	public Integer saveEducationDetails(EducationInputs inputs) {
		DcEducationEntity entity = new DcEducationEntity();
		BeanUtils.copyProperties(inputs, entity);
		
		
		return eduRepo.save(entity).getCaseNo();
	}

	@Override
	public Integer saveChildrenDetails(List<ChildInputs> inputs) {
		
		inputs.forEach(child -> {
			DcChildrenEntity entity = new DcChildrenEntity();
			BeanUtils.copyProperties(inputs, entity);
			
			 childRepo.save(entity);
		});
		
		return inputs.get(0).getCaseNo();
		
	}

	@Override
	public DcSummaryReport showDcSummary(Integer caseNo) {
		DcIncomeEntity incomeEnity = incRepo.findByCaseNo(caseNo);
		DcEducationEntity eduEntity = eduRepo.findByCaseNo(caseNo);
		List<DcChildrenEntity> childEntity = childRepo.findByCaseNo(caseNo); 
		Optional<DcCaseEntity> opt = caseRepo.findById(caseNo);
		String planName = null;
		Integer appId=null;
		if(opt.isPresent()) {
			DcCaseEntity caseEntity = opt.get();
			Integer planId = caseEntity.getPlanid();
			appId = caseEntity.getAppid();
			Optional<PlanEntity> planOpt = planRepo.findById(planId);
			if(planOpt.isPresent()) {
				planName = planOpt.get().getPlanName();
			}
		}
		
		Optional<CitizenApplicationEntity> citizenOpt = citizenRepo.findById(appId);
		CitizenApplicationEntity entity = null;
		if(citizenOpt.isPresent()) 
			entity = citizenOpt.get();
		IncomeInputs income = new IncomeInputs();
		BeanUtils.copyProperties(incomeEnity, income);
		
		EducationInputs education = new EducationInputs();
		BeanUtils.copyProperties(eduEntity, education);
		List<ChildInputs> list = new ArrayList<ChildInputs>();
		childEntity.forEach(child ->{
			ChildInputs childs = new ChildInputs();
			BeanUtils.copyProperties(child, childs);
		});
		
		CitizenAppRegistrationInputs citizen = new CitizenAppRegistrationInputs();
		BeanUtils.copyProperties(entity, citizen);
		
		DcSummaryReport report = new DcSummaryReport();
		report.setPlanName(planName);
		report.setIncomeDetails(income);
		report.setChildrenDetails(list);

		report.setEduDetails(education);
		report.setCitizenInputs(citizen);
		
		
		return report;
	}

}
