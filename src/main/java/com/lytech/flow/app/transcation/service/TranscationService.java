package com.lytech.flow.app.transcation.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lytech.flow.app.transcation.entity.Transcations;
import com.lytech.flow.app.transcation.repository.TranscationRepository;
import com.lytech.flow.app.transcation.vo.TranscationVO;

@Service
public class TranscationService {

	@Autowired
	TranscationRepository transcationRepository;
	
	private static final HashMap<Integer, String> statusCompanyMap = new HashMap<>();

    static {
    	statusCompanyMap.put(1, "A");
    	statusCompanyMap.put(2, "B");
    	statusCompanyMap.put(3, "C");
    	statusCompanyMap.put(4, "D");
    	statusCompanyMap.put(5, "D");
    	statusCompanyMap.put(6, "C");
    	statusCompanyMap.put(7, "B");
    	statusCompanyMap.put(8, "A");
    	statusCompanyMap.put(9, "C");
    	statusCompanyMap.put(10, "B");
    	statusCompanyMap.put(11, "A");
    	statusCompanyMap.put(12, "A");
    	statusCompanyMap.put(13, "NON");
    }
    
	public List<Transcations> getTranscations() {
		
		List<Transcations> transcations = new ArrayList<>();
		transcations = transcationRepository.findAll();
		
		return transcations;
		
	}
	
	public void addTranscation() {
		
		Transcations transcations = new Transcations();
		transcations.setStatus(1);
		transcations.setTodoCompanyType("A");
		transcations.setCreatedAt(new Date());
		transcations.setUpdatedAt(new Date());
		transcationRepository.save(transcations);
		
		
	}
	
	public void updateTranscation(TranscationVO transcationVO) {
		

		Optional<Transcations> dataInDB = transcationRepository.findById(transcationVO.getId());
		Transcations transcations = dataInDB.get();
		
		Integer currentStatus = transcations.getStatus();
		transcations.setStatus(currentStatus + 1);
		transcations.setTodoCompanyType(statusCompanyMap.get(currentStatus + 1));
		transcations.setUpdatedAt(new Date());
		transcationRepository.save(transcations);
	}
}
