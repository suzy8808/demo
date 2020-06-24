package org.bobo.clockin.common.result;

import org.bobo.clockin.constant.SystemConstant;

public class ResultMap<T> {
	/** 业务错误码 */
	private Integer code;
	/** 信息描述 */
	private String message;
	/** 返回数据 */
	private T data;

	private ResultMap(ResultStatus resultStatus, T data) {
		this.code = resultStatus.getCode();
		this.message = resultStatus.getMessage();
		this.data = data;
	}

	public static ResultMap<Void> success() {
		return new ResultMap<Void>(SystemConstant.SUCCESS, null);
	}

	public static <T> ResultMap<T> success(T data) {
		return new ResultMap<T>(SystemConstant.SUCCESS, data);
	}

	public static <T> ResultMap<T> success(ResultStatus resultStatus, T data) {
		if (resultStatus == null) {
			return success(data);
		}
		return new ResultMap<T>(resultStatus, data);
	}

	public static <T> ResultMap<T> failure() {
		return new ResultMap<T>(SystemConstant.INTERNAL_SERVER_ERROR, null);
	}

	public static <T> ResultMap<T> failure(ResultStatus resultStatus) {
		return failure(resultStatus, null);
	}

	public static <T> ResultMap<T> failure(ResultStatus resultStatus, T data) {
		if (resultStatus == null) {
			return new ResultMap<T>(SystemConstant.INTERNAL_SERVER_ERROR, null);
		}
		return new ResultMap<T>(resultStatus, data);
	}

	@Override
	public String toString() {
		return "ResultMap [code=" + code + ", message=" + message + ", data=" + data + "]";
	}

	public Integer getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public T getData() {
		return data;
	}

}
