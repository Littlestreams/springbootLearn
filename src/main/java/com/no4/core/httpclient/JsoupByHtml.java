package com.no4.core.httpclient;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupByHtml {
	public static void main(String[] args) {
     String  url ="https://baijiahao.baidu.com/s?id=1602258607510623538&wfr=spider&for=pc";
     String resResult = getHtmlContest(url);
     //将当前页面转化为Jsoup的Document对象
     Document doc = Jsoup.parse(resResult);
     //获取class=article-content的div标签中列表集合
     Elements els =doc.select("div.article-content");
     for (Element element : els) {
    	//作者的姓名
    	String name = element.select("span.bjh-image-caption").text();
    	//作者图片的路径：
		String imgUrl =element.select("img[class=normal]").text();
		System.out.println("name:"+name);
		System.out.println("imgUrl:"+imgUrl);
		System.out.println("************************");
	}
     
	}
	private static  String getHtmlContest(String uri) {
		       // 创建httpclient对象
				CloseableHttpClient httpClient = HttpClients.createDefault();
				// 使用HttpGet方式发送请求
				HttpGet httpGet = new HttpGet(uri);
				 // 使用HttpPost方式发送请求
				//HttpPost httpPost = new HttpPost("https://blog.csdn.net");
				// 获取网址返回结果
				CloseableHttpResponse httpResponse = null;
				String content = "通信失败";
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
				return content;
			}
	}
