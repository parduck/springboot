package com.sec.admin.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//lombok
@Getter
@Setter
@ToString
public class FirmwareVO {
	private String firmwareID;
	private String modelName;
	private String customer;
	private String currentFwV;
	private String updateFwV;
	private String lifeCycle;
	private String testScn;
	private String svcScn;
	private String lock;
	private Date createDate = new Date();
}
