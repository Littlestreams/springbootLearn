package com.no4.core.exception;

/**
 * 自定义异常类
 * @author MR.Q
 * @date 2019年10月12日 下午2:46:09
 */
public class MyException extends RuntimeException {

  private static final long serialVersionUID = 1L;
  private String statuCode;
  private String resultMsg;
  
public MyException(String statuCode, String resultMsg) {
	super();
	this.statuCode = statuCode;
	this.resultMsg = resultMsg;
}
/**
 * @return the statuCode
 */
public String getStatuCode() {
	return statuCode;
}
/**
 * @param statuCode the statuCode to set
 */
public void setStatuCode(String statuCode) {
	this.statuCode = statuCode;
}
/**
 * @return the resultMsg
 */
public String getResultMsg() {
	return resultMsg;
}
/**
 * @param resultMsg the resultMsg to set
 */
public void setResultMsg(String resultMsg) {
	this.resultMsg = resultMsg;
}
  
}
