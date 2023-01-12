package com.koronapay.service;

import java.util.HashMap;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koronapay.Dao.fundsDao;
import com.koronapay.Dao.transferDao;
import com.koronapay.controller.ui.cancelUI;
import com.koronapay.controller.ui.refundUI;
import com.koronapay.controller.ui.tariffUI;
import com.koronapay.entity.Beneficiary;
import com.koronapay.entity.Funds;
import com.koronapay.entity.Refund;
import com.koronapay.entity.Sender;
import com.koronapay.entity.Transfer;
import com.koronapay.exception.*;
import com.koronapay.repository.fundsRepo;
import com.koronapay.repository.recieverRepo;
import com.koronapay.repository.refundRepo;
import com.koronapay.repository.senderRepo;
import com.koronapay.repository.transferRepo;
import com.koronapay.response.amountToPayResponse;
import com.koronapay.response.amountToRecieveResponse;
import com.koronapay.response.cancelResponse;
import com.koronapay.response.fee;
import com.koronapay.response.info;
import com.koronapay.response.payFunds;
import com.koronapay.response.refundResponse;
import com.koronapay.response.tariffResponse;
import com.koronapay.response.transferAmountToRecieveResponse;
import com.koronapay.response.transferamountToPayResponse;

import java.util.*;

@Service
public class transferServiceImpl implements transferService {
	
	private Map<Integer,Transfer> transfers=new HashMap<>(); 
	
	private Map<String,Refund> refunds=new HashMap<>();

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private transferRepo transferrepo;
	
	@Autowired
	private senderRepo senderrepo;
	
	@Autowired
	private recieverRepo recieverrepo;
	
	@Autowired
	private fundsRepo fundsrepo;
	
	@Autowired
	private refundRepo refundrepo;
	
	@Override
	public transferDao transfer(transferDao dao,long senderId,int recieverId,int fundId) {
		
		Sender sender=this.senderrepo.findById(senderId).orElseThrow(()->new ResourceNotFoundException("sender","senderId",senderId));
		Beneficiary reciever=this.recieverrepo.findById(recieverId).orElseThrow(()->new ResourceNotFoundException("reciever","reciverId",recieverId));
		Funds fund=this.fundsrepo.findById(fundId).orElseThrow(()->new ResourceNotFoundException("fund","fundId",fundId));
		Transfer transfer=this.modelMapper.map(dao, Transfer.class);
		transfer.setSender(sender);
		transfer.setReciever(reciever);
		transfer.setFund(fund);
		//Transfer savedtransfer=this.transferrepo.save(transfer);
		transfer.setTransferStatus("In Process");
		this.transfers.put(transfer.getTransferId(), transfer);
		return this.modelMapper.map(transfer, transferDao.class);
	}

	@Override
	public transferDao confirmTransfer(transferDao dao) {
		Transfer transfer=this.transfers.get(dao.getTransferId());
		transfer.setTransferStatus("SUCCESS");
		
		Transfer savedtransfer=this.transferrepo.save(transfer);
		
		return this.modelMapper.map(savedtransfer, transferDao.class);
	}

	@Override
	public info calculateAmountToPayWithCurrencyConversion(transferDao dao) {
		double amount=Double.parseDouble(dao.getFund().getCurrency());
		double fromCurrency=Double.parseDouble(dao.getFund().getCurrency());
		double toCurrency=Double.parseDouble(dao.getToCurrency());
		return null;
	}

	@Override
	public String getTransferStatus(String oid) {
		Transfer transfer=this.transferrepo.findByOid(oid);
		
		return transfer.getTransferStatus();
	}

	@Override
	public cancelResponse cancel(cancelUI c) {
		String oid=c.getOid();
		Transfer transfer=this.transferrepo.findByOid(oid);
		this.transferrepo.delete(transfer);
		return new cancelResponse(new info("SUCCESS","0"),oid);
	}

	@Override
	public refundResponse refund(refundUI r) {
		
		Transfer transfer=this.transferrepo.findByOid(r.getOid());
		Refund refund=new Refund();
		refund.setTransfer(transfer);
		refund.setRefundId((int) Math.random());
		String oid=r.getOid();
		refundResponse refundres=new refundResponse();
		refundres.setAmountToBeRefunded(transfer.getFund().getAmount());
		refundres.setOid(oid);
		refundres.setComission(1000);
		refundres.setI(new info("SUCCESS","0"));
		refunds.put(oid,refund );
		return refundres;
	}

	@Override
	public info confirmRefund(refundUI ui) {
		String oid=ui.getOid();
		Refund refund=refunds.get(oid);

		this.refundrepo.save(refund);
		return new info("SUCCESS","0");
	}

	@Override
	public tariffResponse calculateTariff(tariffUI ui, long senderId, int fundId) {
		tariffResponse response=new tariffResponse();
		response.setI(new info("SUCCESS","0"));
		response.setToCountry(ui.getToCountryISO());
		Funds f=this.fundsrepo.findById(fundId).orElseThrow(()->new ResourceNotFoundException("funds","fundId",fundId));
		response.setFeeTotal(new fee(f.getAmount(),f.getCurrency()));
		return response;
	}

	@Override
	public amountToPayResponse amountToPay(tariffUI ui, long senderId, int fundId) {
		amountToPayResponse response=new amountToPayResponse();
		response.setI(new info("SUCCESS","0"));
		Funds f=this.fundsrepo.findById(fundId).orElseThrow(()->new ResourceNotFoundException("funds","fundId",fundId));
		response.setFund(this.modelMapper.map(f,fundsDao.class));
		response.setToCountryISO(ui.getToCountryISO());
		response.setExchangeRate(UUID.randomUUID().toString());
		response.setFeeTotal(new fee(f.getAmount()-4000,f.getCurrency()));
		return response;
	}

	@Override
	public amountToRecieveResponse amountToRecieve(tariffUI ui, long senderId, int fundId) {
		amountToRecieveResponse response=new amountToRecieveResponse();
		response.setI(new info("SUCCESS","0"));
		Funds f=this.fundsrepo.findById(fundId).orElseThrow(()->new ResourceNotFoundException("funds","fundId",fundId));
		response.setFund(this.modelMapper.map(f,fundsDao.class));
		response.setToCountryISO(ui.getToCountryISO());
		response.setExchangeRate(UUID.randomUUID().toString());
		response.setFeeTotal(new fee(f.getAmount()-4000,f.getCurrency()));
		response.setPayfunds(new payFunds(f.getAmount(),f.getCurrency()));;
		return response;
		
	}

	@Override
	public transferamountToPayResponse transferamountToPay(transferDao ui, int transferId) {
		transferamountToPayResponse response=new transferamountToPayResponse();
		response.setI(new info("SUCCESS","0"));
		Transfer t=this.transferrepo.findById(transferId).orElseThrow(()->new ResourceNotFoundException("transfer","transferId",transferId));
		response.setSendFunds(this.modelMapper.map(t.getFund(),fundsDao.class));
	
		response.setTransfer(this.modelMapper.map(t, transferDao.class));
		return response;
	
	}

	@Override
	public transferAmountToRecieveResponse transferamountToRecieve(transferDao ui, int transferId) {
		transferAmountToRecieveResponse response=new transferAmountToRecieveResponse();
		response.setI(new info("SUCCESS","0"));
		Transfer t=this.transferrepo.findById(transferId).orElseThrow(()->new ResourceNotFoundException("transfer","transferId",transferId));
		response.setSendFunds(this.modelMapper.map(t.getFund(),fundsDao.class));
		response.setPayfunds(new payFunds(t.getFund().getAmount(),t.getFund().getCurrency()));
		response.setTransfer(this.modelMapper.map(t, transferDao.class));
		return response;
	
	}
}
