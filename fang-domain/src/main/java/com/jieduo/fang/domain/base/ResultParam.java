package com.jieduo.fang.domain.base;

/**
 * 前台返回对象
 * 
 * @author lyh
 *
 */
public class ResultParam {
    private boolean flag = true;
    private String code;
    private String message;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
