package com.koronapay.controller.ui;

import java.util.Date;
import java.util.List;

import com.koronapay.Dao.fundsDao;
import com.koronapay.Dao.senderDao;
import com.koronapay.entity.City;
import com.koronapay.entity.Transfer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class tariffUI {

	private String toCountryISO;
	private String tariffLocationId;
	private fundsDao fund;
	private senderDao sender;
}
