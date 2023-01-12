package com.koronapay.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koronapay.Dao.senderDao;
import com.koronapay.entity.Sender;
import com.koronapay.repository.senderRepo;

@Service
public class senderServiceImpl implements senderService {

	@Autowired
	private senderRepo senderrepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public senderDao addSender(senderDao dao) {
		
		Sender sender=this.modelMapper.map(dao, Sender.class);
		Sender savedSender=this.senderrepo.save(sender);
		
		
		return this.modelMapper.map(savedSender, senderDao.class);
	}

}
