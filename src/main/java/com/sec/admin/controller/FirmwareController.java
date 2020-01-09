package com.sec.admin.controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import com.sec.admin.domain.BoardVO;
import com.sec.admin.domain.FirmwareVO;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class FirmwareController {
	
	public FirmwareController() {
		System.out.println("===>FirmwareController created..");
	}
	
	@GetMapping("/getFirmwareList")
	public List<FirmwareVO> getFirmwareList() {
		List<FirmwareVO> firmwareList = new ArrayList<FirmwareVO>();
		
		//change to JPA
		for (int i=1;i<=10;i++) {
			FirmwareVO firmware = new FirmwareVO();
		
			
			firmware.setFirmwareID("FW-000"+i);
			firmware.setModelName("SM-G999S");
			firmware.setCustomer("KOO");
			firmware.setCurrentFwV("11111");
			firmware.setUpdateFwV("22222");
			firmware.setLifeCycle("test");
			firmware.setTestScn("Y");
			firmware.setSvcScn("N");
			firmware.setLock("N");
			
			firmware.setCreateDate(new Date());
			
			firmwareList.add(firmware);
		}
		return firmwareList;
	}

}
