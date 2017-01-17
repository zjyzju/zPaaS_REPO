package com.zpaas;

/**
 * zPaaS异常类
 * @author ZhangJunyong
 *
 */
public class PaasException extends Exception {
	private static final long serialVersionUID = 1485951470027417257L;
	private String errorCode;
	private String errorDetail;
	
	public PaasException(String errorCode, String errorDetail) {
		super(errorCode + ":" + errorDetail);
		this.errorCode = errorCode;
		this.errorDetail = errorDetail;
	}
	
	public PaasException(String errorCode, String errorDetail, Exception ex) {
		super(errorCode + ":" + errorDetail,ex);
		this.errorCode = errorCode;
		this.errorDetail = errorDetail;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorDetail() {
		return errorDetail;
	}

	public void setErrorDetail(String errorDetail) {
		this.errorDetail = errorDetail;
	}
		
}
