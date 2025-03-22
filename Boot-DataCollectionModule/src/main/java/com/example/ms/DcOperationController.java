package com.example.ms;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bindingd.ChildInputs;
import com.example.bindingd.DcSummaryReport;
import com.example.bindingd.EducationInputs;
import com.example.bindingd.IncomeInputs;
import com.example.bindingd.PlanSelectionInputs;
import com.example.service.DcServicemgmt;


@RestController
@RequestMapping("/Dc-api")
public class DcOperationController {

	@Autowired
	private DcServicemgmt mgmt;
	
	@PostMapping("/generatedCaseNo/{appid}")
	public ResponseEntity<String > getCaseNumber(@PathVariable int appid){
		
		int id = mgmt.generateCaseNo(appid);
		return new ResponseEntity<String>("Generated case No "+id, HttpStatus.CREATED);
		
		
	}
	
	
	@GetMapping("/planNames")
	public ResponseEntity<List<String>> showPlanNames(){
		List<String>  list= mgmt.showAllPlanNames();
		return new ResponseEntity<List<String>>(list,HttpStatus.OK );
	}
	
	@PutMapping("/updatePlanSelection")
	public ResponseEntity<Integer> savePlanSelection(@RequestBody PlanSelectionInputs inputs){
		int plans= mgmt.savePlanSelection(inputs);

		return new ResponseEntity<Integer>(plans, HttpStatus.CREATED);
				
	
	}
	@PostMapping("saveIncome")
	public ResponseEntity<Integer> saveIncome(@RequestBody IncomeInputs inputs){
		
		int income = mgmt.saveIncomeDetails(inputs);
		return new ResponseEntity<Integer>(income, HttpStatus.CREATED);
		
	}
	@PostMapping("saveEducation")
	public ResponseEntity<Integer> saveIncome(@RequestBody EducationInputs inputs){
		
		int edu = mgmt.saveEducationDetails(inputs);
		return new ResponseEntity<Integer>(edu, HttpStatus.CREATED);
		
	}
	@PostMapping("saveChildren")
	public ResponseEntity<Integer> saveIncome(@RequestBody List<ChildInputs> inputs){
		
		int caseNo = mgmt.saveChildrenDetails(inputs);
		return new ResponseEntity<Integer>(caseNo, HttpStatus.CREATED);
		
	}
	@GetMapping("/summary/{caseNo}")
	public ResponseEntity<DcSummaryReport> report (@PathVariable 	int caseNo ){
		DcSummaryReport repots = mgmt.showDcSummary(caseNo);
		
		return new ResponseEntity<DcSummaryReport>(repots, HttpStatus.ACCEPTED);
	}
}
