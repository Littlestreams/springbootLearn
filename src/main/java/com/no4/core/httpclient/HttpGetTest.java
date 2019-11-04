package com.no4.core.httpclient;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * 发送Get请求
 * 
 * @author MR.Q
 * @date 2019年10月31日 下午1:57:31
 */
public class HttpGetTest {
    private static final String RESPONSE_CONTENT = "通信失败";
	public static void main(String[] args) {
		// 创建httpclient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		// 使用HttpGet方式发送请求
		HttpGet httpGet = new HttpGet("https://baijiahao.baidu.com/s?id=1602258607510623538&wfr=spider&for=pc");
		 // 使用HttpPost方式发送请求
		//HttpPost httpPost = new HttpPost("https://blog.csdn.net");
		// 获取网址返回结果
		CloseableHttpResponse httpResponse = null;
		String content = RESPONSE_CONTENT;
		try {
			// 执行get请求
			httpResponse = httpClient.execute(httpGet);
			//输出状态码 200表示请求成功
			System.out.println("status:"+httpResponse.getStatusLine().getStatusCode());
	        //获取响应实体
			HttpEntity entity =httpResponse.getEntity();
			System.out.println("content-type:"+entity.getContentType().getValue());
			if(entity!=null) {
			 //设置返回编码的格式，防止响应乱码
			 content=EntityUtils.toString(entity, "utf-8");
			 System.out.println("content:"+content);
			 EntityUtils.consume(entity);
			}	
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			  if(httpResponse!=null) {
				  try {
					httpResponse.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
              }
			  if(httpClient!=null) {
				  try {
					  httpClient.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
              }
		}
	}
}
