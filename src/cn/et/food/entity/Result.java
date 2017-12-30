package cn.et.food.entity;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Result {
	private Integer code;
	private String message;
	public void setCode(Integer code) {
		this.code = code;
	}
	public int getCode() {
		return code;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMessage() {
		if(message!=null && message.length()>1000)
			return message.substring(0, 1000);
		return message;
	}
	public void setMessage(Exception msg) {
		ByteArrayOutputStream baos=new ByteArrayOutputStream();
		msg.printStackTrace(new PrintStream(baos));
		this.message = new String(baos.toByteArray());
	}
}
