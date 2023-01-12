package com.koronapay.service;

import com.koronapay.Dao.transferDao;
import com.koronapay.controller.ui.cancelUI;
import com.koronapay.controller.ui.refundUI;
import com.koronapay.controller.ui.tariffUI;
import com.koronapay.response.*;

public interface transferService {

	transferDao transfer(transferDao dao,long senderId,int recieverId,int fundId);
	
	transferDao confirmTransfer(transferDao dao);
	
	info calculateAmountToPayWithCurrencyConversion(transferDao dao);
	
	String getTransferStatus(String oid);
	
	cancelResponse cancel(cancelUI c);
	
	refundResponse refund(refundUI r);
	
	info confirmRefund(refundUI ui);
	
	tariffResponse calculateTariff(tariffUI ui,long senderId,int fundId);
	
	amountToPayResponse amountToPay(tariffUI ui,long senderId,int fundId);
	
	amountToRecieveResponse amountToRecieve(tariffUI ui,long senderId,int fundId);
	
	transferamountToPayResponse transferamountToPay(transferDao ui,int transferId);
	
	transferAmountToRecieveResponse transferamountToRecieve(transferDao ui,int transferId);
	
}
