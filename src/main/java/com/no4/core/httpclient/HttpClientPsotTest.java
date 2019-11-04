package com.no4.core.httpclient;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;

import com.alibaba.fastjson.JSON;
import com.no4.core.model.User;

public class HttpClientPsotTest {
	public static void main(String[] args) {
     //获取httpclient对象
	 CloseableHttpClient httpClient =HttpClients.createDefault();
	 //请求参数
	 User u = new User();
	 u.setAge("18");
	 u.setLikes("cat");
	 u.setUserName("Jsaon");
	 Map<String, String> param = new HashMap<String, String>();
	 param.put("flag", "true");
	 
	// 将参数放入键值对类NameValuePair中,再放入集合中
	List<NameValuePair> params = new ArrayList<>();
	//循环获取map集合的参数
    for(String key:param.keySet()) {
	 params.add(new BasicNameValuePair(key, param.get(key)));
    }
	// 设置uri信息,并将参数集合放入uri;
    // 注:这里也支持一个键值对一个键值对地往里面放setParameter(String key, String value)
    URI uri =null;
 	try {
		uri = new URIBuilder()
				.setScheme("http")
				.setHost("localhost")
				.setPort(9527)
				.setPath("/dovepay/v2/userInfo")
				.setParameters(params)
				.build();
	HttpPost httpPost = new HttpPost(uri);
    String jsonStr = JSON.toJSONString(u);
    System.out.println("jsonStr:"+jsonStr);
		httpPost.addHeader("Content-Type", "application/json");
		httpPost.setEntity(new StringEntity(jsonStr,ContentType.APPLICATION_JSON));
		//获取响应
		CloseableHttpResponse httpResponse =httpClient.execute(httpPost);
		//获取响应实体
		HttpEntity httpEntity =httpResponse.getEntity();
		System.out.println("content-type:"+httpEntity.getContentType().getValue());
		String content =null;
		if(httpEntity!=null) {
		 //设置返回编码的格式，防止响应乱码
		 content=EntityUtils.toString(httpEntity, "utf-8");
		 System.out.println("content:"+content);
		 EntityUtils.consume(httpEntity);
		}	
	} catch (ClientProtocolException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (URISyntaxException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	}
}
