package org.bobo.clockin.common.result;

public class ResultStatus {

	/** 业务异常码 */
	private Integer code;
	/** 业务异常信息描述 */
	private String message;

	public ResultStatus() {
		super();
	}

	public ResultStatus(Integer code, String message) {

		this.code = code;
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
