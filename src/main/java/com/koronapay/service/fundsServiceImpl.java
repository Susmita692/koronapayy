package com.koronapay.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koronapay.Dao.fundsDao;
import com.koronapay.entity.Funds;
import com.koronapay.repository.fundsRepo;

@Service
public class fundsServiceImpl implements fundsService{
	
	@Autowired
	private fundsRepo fundsrepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public fundsDao addFund(fundsDao dao) {
		Funds fund=this.modelMapper.map(dao, Funds.class);
		Funds savedFund=this.fundsrepo.save(fund);
		
		return this.modelMapper.map(savedFund, fundsDao.class);
	}

}
