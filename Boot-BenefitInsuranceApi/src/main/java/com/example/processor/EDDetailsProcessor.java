package com.example.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.example.binding.EligibilityDeterminationBinding;
import com.example.entity.EligibilityDeterminationEntity;
@Component
public class EDDetailsProcessor implements ItemProcessor<EligibilityDeterminationEntity, EligibilityDeterminationBinding> {

	@Override
	public EligibilityDeterminationBinding process(EligibilityDeterminationEntity item) throws Exception {
		if(item.getPlanStatus().equalsIgnoreCase("approved")) {
			EligibilityDeterminationBinding details = new EligibilityDeterminationBinding();
			BeanUtils.copyProperties(item, details);
			return details;
		}
		return null;
	}

}
