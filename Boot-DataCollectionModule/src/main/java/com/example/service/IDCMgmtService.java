package com.example.service;

import java.util.List;

import com.example.bindingd.ChildInputs;
import com.example.bindingd.DcSummaryReport;
import com.example.bindingd.EducationInputs;
import com.example.bindingd.IncomeInputs;
import com.example.bindingd.PlanSelectionInputs;

public interface IDCMgmtService {

	
	
	
	public Integer generateCaseNo(Integer appid);
	public List<String> showAllPlanNames();
	public Integer savePlanSelection(PlanSelectionInputs inputs);
	public Integer saveIncomeDetails(IncomeInputs inputs);
	public Integer saveEducationDetails(EducationInputs inputs);
	public Integer saveChildrenDetails(List<ChildInputs> inputs);
	public DcSummaryReport showDcSummary(Integer caseNo);
}
