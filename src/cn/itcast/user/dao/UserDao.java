package cn.itcast.user.dao;

import java.io.*;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import cn.itcast.user.domain.User;

/**
 * 数据类
 * @author tsingxu
 *
 */
public class UserDao {
	private String path = "D:/javacode/users.xml"; //依赖数据文件
	
	/**
	 * 按用户名查询
	 * @param username
	 * @return
	 */
	public User findByUsername(String username) {
		
		/**
		 * 1、得到Document
		 * 2、xpath查询
		 * 3、校验查询结果是否为null
		 * 4、不为null,需要把Element封装到User对象中
		 */
		//创建解析器
		SAXReader reader = new SAXReader();
		try {
			Document doc = reader.read(path);
			//通过xpath查询
			Element ele = (Element)doc.selectSingleNode("//user[@username='"+ username +"']");
			//校验ele是否为null
			if(ele == null) {
				return null;
			}
			//把ele的数据封装到User对象中
			User user = new User();
			String attrUsername = ele.attributeValue("username");
			String attrPassword = ele.attributeValue("password");
			user.setUsername(attrUsername);
			user.setPassword(attrPassword);
			return user;
			
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		
	}
	
	/**
	 * 添加用户
	 * @param user
	 */
	public void add(User user) {
		
		/**
		 * 1、得到Document
		 * 2、通过Document得到root元素
		 * 3、使用参数user,转发给Element对象
		 * 4、把Element添加到root元素中
		 * 5、保存Docement
		 */
		SAXReader reader = new SAXReader();
		try {
			
			//得到document
			Document doc = reader.read(path);
			//得到root
			Element root = doc.getRootElement();
			//通过根元素创建新元素
			Element userEle = root.addElement("user");
			//为userEle设置属性
			userEle.addAttribute("username", user.getUsername());
			userEle.addAttribute("password",user.getPassword());
			//保存文档
			OutputFormat format = new OutputFormat("\t",true); //缩进使用\t，是否换行，使用是！
			format.setTrimText(true);//清空原有换行和缩进
			XMLWriter writer;
			try {
				writer = new XMLWriter(new OutputStreamWriter(new FileOutputStream(path),"UTF-8"),format);

				writer.write(doc);//保存document对象
				writer.close();
				
			} catch (Exception e) {
				
				// TODO Auto-generated catch block
				throw new RuntimeException(e);
			}
			
		} catch (DocumentException e) {
			
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		
	}
}
