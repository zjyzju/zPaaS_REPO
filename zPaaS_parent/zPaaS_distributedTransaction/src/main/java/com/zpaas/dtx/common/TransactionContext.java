package com.zpaas.dtx.common;

import java.io.Serializable;
import java.util.Date;

import net.sf.json.JSONObject;

public class TransactionContext implements Serializable {
	private static final long serialVersionUID = -333457930512493843L;

	public static final Integer TRANSACTION_STATUS_NEW = 10;
	public static final Integer TRANSACTION_STATUS_COMMIT = 20;
	public static final Integer TRANSACTION_STATUS_ROLLBACK = 25;
	public static final Integer TRANSACTION_STATUS_DELIVERED = 30;
	public static final Integer TRANSACTION_STATUS_PART_FAILED = 70;
	public static final Integer TRANSACTION_STATUS_PART_SUCCEED = 80;
	public static final Integer TRANSACTION_STATUS_ALL_SUCCEED = 90;
	
	public static final Integer ASSURED_TRANSACTION_STATUS_NEW = 11;
	public static final Integer ASSURED_TRANSACTION_STATUS_COMMIT = 21;
	public static final Integer ASSURED_TRANSACTION_STATUS_ROLLBACK = 26;
	public static final Integer ASSURED_TRANSACTION_STATUS_PART_FAILED = 71;
	public static final Integer ASSURED_TRANSACTION_STATUS_PART_FINISH = 81;
	public static final Integer ASSURED_TRANSACTION_STATUS_ALL_FINISH = 91;

	private Long transactionId;
	private String distributeId;
	private String distributeTableName;

	private Integer status;
	private Long startTime;
	private Long finishTime;
	private String participant;
	private Integer sendTimes;
	private Date statusTime;

	private String name;
	private String content;

	private Integer participantAmount;
	private String totalParticipants;
	private String succeedParticipants;
	private String failedParticipants;

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getStartTime() {
		return startTime;
	}

	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}

	public Long getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Long finishTime) {
		this.finishTime = finishTime;
	}

	public String getParticipant() {
		return participant;
	}

	public void setParticipant(String participant) {
		this.participant = participant;
	}

	public Integer getSendTimes() {
		return sendTimes;
	}

	public void setSendTimes(Integer sendTimes) {
		this.sendTimes = sendTimes;
	}

	public Date getStatusTime() {
		return statusTime;
	}

	public void setStatusTime(Date statusTime) {
		this.statusTime = statusTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getParticipantAmount() {
		return participantAmount;
	}

	public void setParticipantAmount(Integer participantAmount) {
		this.participantAmount = participantAmount;
	}

	public String getTotalParticipants() {
		return totalParticipants;
	}

	public void setTotalParticipants(String totalParticipants) {
		this.totalParticipants = totalParticipants;
	}

	public String getSucceedParticipants() {
		return succeedParticipants;
	}

	public void setSucceedParticipants(String succeedParticipants) {
		this.succeedParticipants = succeedParticipants;
	}

	public String getFailedParticipants() {
		return failedParticipants;
	}

	public void setFailedParticipants(String failedParticipants) {
		this.failedParticipants = failedParticipants;
	}

	public String getDistributeId() {
		return distributeId;
	}

	public void setDistributeId(String distributeId) {
		this.distributeId = distributeId;
	}

	public String getDistributeTableName() {
		return distributeTableName;
	}

	public void setDistributeTableName(String distributeTableName) {
		this.distributeTableName = distributeTableName;
	}

	public String toString() {
		return JSONObject.fromObject(this).toString();
	}
}
