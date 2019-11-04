package com.no4.core.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 配置类信息
 * 
 * @author MR.Q
 * @date 2019年10月11日 上午11:21:48
 */
@Component
@ConfigurationProperties(prefix = "student")
public class StudentCore {
	private String uname;
	private String uage;
	private String like;
	/**
	 * @return the uname
	 */

	public String getUname() {
		return uname;
	}

	/**
	 * @param uname
	 *            the uname to set
	 */
	public void setUname(String uname) {
		this.uname = uname;
	}

	/**
	 * @return the uage
	 */
	public String getUage() {
		return uage;
	}

	/**
	 * @param uage
	 *            the uage to set
	 */
	public void setUage(String uage) {
		this.uage = uage;
	}

	/**
	 * @return the like
	 */
	public String getLike() {
		return like;
	}

	/**
	 * @param like
	 *            the like to set
	 */
	public void setLike(String like) {
		this.like = like;
	}

}
