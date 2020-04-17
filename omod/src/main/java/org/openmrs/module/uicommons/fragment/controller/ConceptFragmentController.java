package org.openmrs.module.uicommons.fragment.controller;

import org.openmrs.Concept;
import org.openmrs.ConceptAnswer;
import org.openmrs.api.ConceptService;
import org.openmrs.ui.framework.annotation.FragmentParam;
import org.openmrs.ui.framework.annotation.SpringBean;
import org.openmrs.ui.framework.fragment.FragmentModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConceptFragmentController {

	public void controller(FragmentModel model,
			@SpringBean("conceptService") ConceptService conceptService,
			@FragmentParam(value = "questionConceptId", required = false) String questionConceptId) {

		Concept questionConcept = conceptService.getConceptByUuid(questionConceptId);
		List<Map<String, String>> conceptOptions = new ArrayList<Map<String, String>>();

		for (ConceptAnswer answer : questionConcept.getAnswers()) {
            Concept concept = answer.getAnswerConcept();
            Map<String, String> option = new HashMap<String, String>();
            option.put("conceptId", concept.getId().toString());
            option.put("conceptName", concept.getName().getName());
            conceptOptions.add(option);
        }

		model.addAttribute("conceptOptions", conceptOptions);
	}
}
