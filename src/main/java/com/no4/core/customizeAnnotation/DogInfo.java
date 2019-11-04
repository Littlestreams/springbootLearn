package com.no4.core.customizeAnnotation;
/**
 * 注解使用
 * @author MR.Q
 * @date 2019年10月25日 下午5:26:05
 */
public class DogInfo {
	@AnimalName
	private String orangeName;
	@DogShow(color="黑白色")
	private String dogInfo;
	/**
	 * @return the orangeName
	 */
	public String getOrangeName() {
		return orangeName;
	}
	/**
	 * @param orangeName the orangeName to set
	 */
	public void setOrangeName(String orangeName) {
		this.orangeName = orangeName;
	}
	/**
	 * @return the dogInfo
	 */
	public String getDogInfo() {
		return dogInfo;
	}
	/**
	 * @param dogInfo the dogInfo to set
	 */
	public void setDogInfo(String dogInfo) {
		this.dogInfo = dogInfo;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DogInfo [orangeName=" + orangeName + ", dogInfo=" + dogInfo + "]";
	}


}
