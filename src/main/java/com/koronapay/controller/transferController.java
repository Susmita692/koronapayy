package com.koronapay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koronapay.Dao.transferDao;
import com.koronapay.controller.ui.cancelUI;
import com.koronapay.controller.ui.refundUI;
import com.koronapay.controller.ui.tariffUI;
import com.koronapay.response.amountToPayResponse;
import com.koronapay.response.amountToRecieveResponse;
import com.koronapay.response.cancelResponse;
import com.koronapay.response.info;
import com.koronapay.response.refundResponse;
import com.koronapay.response.tariffResponse;
import com.koronapay.response.transferAmountToRecieveResponse;
import com.koronapay.response.transferamountToPayResponse;
import com.koronapay.service.transferService;

@RestController
@RequestMapping("/")
public class transferController {

	@Autowired
	private transferService transferservice;
	
	@PostMapping("Transfer/{fundId}/{senderId}/{recieverId}")
	public ResponseEntity<transferDao> transfer(@RequestBody transferDao dao,@PathVariable Integer fundId,@PathVariable Long senderId,@PathVariable Integer recieverId){
		
		transferDao t=this.transferservice.transfer(dao, senderId, recieverId, fundId);
		return new ResponseEntity<>(t,HttpStatus.CREATED);
	}
	
	@PostMapping("ConfirmTransfer")
	public ResponseEntity<transferDao> confirmTransfer(@RequestBody transferDao dao){
		transferDao t=this.transferservice.confirmTransfer(dao);
		return ResponseEntity.ok(t);
	}
	
	@PostMapping("FxTransferAmountToPay")
	public ResponseEntity<transferDao> currencyConversionAmtPay(@RequestBody transferDao dao){
		return null;
	}
	
	@GetMapping("/TransferStatus/{oid}")
	public ResponseEntity<String> getTransferStatus(@PathVariable String oid){
		String status=this.transferservice.getTransferStatus(oid);
		return ResponseEntity.ok(status);
	}
	
	@PostMapping("Cancel")
	public ResponseEntity<cancelResponse> cancel(@RequestBody cancelUI ui){
		cancelResponse response=this.transferservice.cancel(ui);
		return ResponseEntity.ok(response);
	}
	
	@PostMapping("Refund")
	public ResponseEntity<refundResponse> refund(@RequestBody refundUI ui){
		
		refundResponse response=this.transferservice.refund(ui);
		return ResponseEntity.ok(response);
	}
	
	@PostMapping("ConfirmRefund")
	public ResponseEntity<info> confirmRefund(@RequestBody refundUI ui){
		return ResponseEntity.ok(this.transferservice.confirmRefund(ui));
		
	}
	
	@PostMapping("TariffCalculation/{senderId}/{fundId}")
	public ResponseEntity<tariffResponse> calculateTariff(@RequestBody tariffUI ui,@PathVariable long senderId,@PathVariable int fundId){
		
		return ResponseEntity.ok(this.transferservice.calculateTariff(ui, senderId, fundId));
		
	}
	
	@PostMapping("FxFeeAmountToPay/{senderId}/{fundId}")
	public ResponseEntity<amountToPayResponse> amountToPay(@RequestBody tariffUI ui,@PathVariable long senderId,@PathVariable int fundId){
		
		return ResponseEntity.ok(this.transferservice.amountToPay(ui, senderId, fundId));
	}
	
	@PostMapping("FxFeeAmountToRecieve/{senderId}/{fundId}")
public ResponseEntity<amountToRecieveResponse> amountToRecieve(@RequestBody tariffUI ui,@PathVariable long senderId,@PathVariable int fundId){
		
		return ResponseEntity.ok(this.transferservice.amountToRecieve(ui, senderId, fundId));
	}

@PostMapping("FxTransferAmountToPay/{transferId}")
public ResponseEntity<transferamountToPayResponse> transferamountToPay(@RequestBody transferDao ui,@PathVariable int transferId){
	
	return ResponseEntity.ok(this.transferservice.transferamountToPay(ui, transferId));
}

@PostMapping("FxTransferAmountToRecieve/{transferId}")
public ResponseEntity<transferAmountToRecieveResponse> transferamountToRecieve(@RequestBody transferDao ui,@PathVariable int transferId){
	
	return ResponseEntity.ok(this.transferservice.transferamountToRecieve(ui, transferId));
}

}
