package com.koronapay.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koronapay.Dao.recieverDao;
import com.koronapay.entity.Beneficiary;
import com.koronapay.repository.recieverRepo;

@Service
public class recieverService {

	@Autowired
	private recieverRepo recieverrepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public recieverDao add(recieverDao dao) {
		
		Beneficiary b=this.modelMapper.map(dao,Beneficiary.class);
		Beneficiary b1=this.recieverrepo.save(b);
		return this.modelMapper.map(b1, recieverDao.class);
		
	}
}
