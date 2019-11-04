package com.no4.core.fileTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.no4.core.model.Student;
@RunWith(SpringRunner.class)
@SpringBootTest
public class FileTest {
  @Test
  public void testCreatAndDeleteFile() {
	  //不使用 Java 提供的分隔符字段，注意：这样写只能在 Windows 平台有效
     // File f2 = new File("D:\\iotest\\a.txt");
	  //使用 Java 提供的分隔符,创建文件对象
      File f2 = new File("D:"+File.separator+"iotest"+File.separator+"a.txt");
      //System.out.println(f1);
      System.out.println(f2);
      if(f2.exists()) {//判断文件是否存在
        f2.delete();//删除文件
        System.out.println("该文件已存在");
      }else {
	    try {
		f2.createNewFile();//创建该文件
		System.out.println("文件不存在，已创建新文件");
		String name=f2.getName();//获取文件名
	    long length =f2.length();//获取文件长度
	    boolean read =f2.canRead();//是否可读
	    long lastTime = f2.lastModified();//文件最后修改时间
	    String  path = f2.getAbsolutePath();//获取文件的绝对路径
	    System.out.println(name);
	    System.out.println(length);
	    System.out.println(read);
	    System.out.println(lastTime);
	    System.out.println("文件的绝对路径："+path);
	} catch (IOException e) {
		e.printStackTrace();
	}
	   
   }
  }
  @Test
  public void testOutputStream() {
	  File f =new File("D:"+File.separator+"iotest"+File.separator+"a.txt");
	  ObjectOutputStream oos=null;
	  try {
		OutputStream os = new FileOutputStream(f);
		 oos =new ObjectOutputStream(os);
		oos.writeObject(new Student("张三", 18, "dog"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
  }
  @Test
  public void testInputStream() throws ClassNotFoundException {
	  ObjectInputStream ois =null;
	  try {
		InputStream in = new FileInputStream("D:"+File.separator+"iotest"+File.separator+"a.txt");
	     ois =new ObjectInputStream(in);
	    Student s=(Student)ois.readObject();
	    System.out.println(s.toString());
	  } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			ois.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
  }
}