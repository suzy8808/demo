package org.bobo.clockin.constant;

import org.bobo.clockin.common.result.ResultStatus;

public class SystemConstant {

	public static final int DISABLE = 1;
	public static final int ABLE = 0;

	// Errors Code
	public static final int FIELD_ERROR = 501;
	public static final String FIELD_ERROR_MSG = "参数不正确";


	// common result status
	public static final ResultStatus SUCCESS = new ResultStatus(200, "OK");
	public static final ResultStatus BAD_REQUEST = new ResultStatus(400, "Bad Request");
	public static final ResultStatus INTERNAL_SERVER_ERROR = new ResultStatus(500, "Internal Server Error");


	//时间
	public static final int CLOCK_6=6;
	public static final int CLOCK_4=4;

	//打卡状态
	public static final int CLOCKIN_STATUS_SUCCESS=1;
	public static final int CLOCKIN_STATUS_FAIL=2;
	public static final int CLOCKIN_STATUS_EARLY=3;
	public static final int CLOCKIN_STATUS_LATE=4;
	public static final int CLOCKIN_STATUS_REST=5;
	public static final int CLOCKIN_STATUS_EXCEPTION=6;

}
