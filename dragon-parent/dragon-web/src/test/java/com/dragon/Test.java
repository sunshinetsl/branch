package com.dragon;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.hibernate.SessionFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.dragon.entity.Area;
import com.dragon.service.func.AreaServiceImpl;

public class Test {

	public static void main(String[] args) {
		List<Provinces> listp = null;
		List<City> clist = null;
		List<Districts> dlist = null;
		try {
			SAXReader reader = new SAXReader();
			Document document = reader.read(new File("C:\\Users\\Administrator\\Desktop\\全国省市区数据库\\Provinces.xml"));
			Element root = document.getRootElement();
			listp = new ArrayList<>();
			for(Iterator iter = root.elementIterator(); iter.hasNext();){
	            Element e = (Element)iter.next();  
	            Provinces p = new Provinces();
	            p.setID(e.attributeValue("ID"));
	            p.setProvinceName(e.attributeValue("ProvinceName"));
	            listp.add(p);
	        }
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			SAXReader reader = new SAXReader();
			Document document = reader.read(new File("C:\\Users\\Administrator\\Desktop\\全国省市区数据库\\Cities.xml"));
			Element root = document.getRootElement();
			clist = new ArrayList<>();
			for(Iterator iter = root.elementIterator(); iter.hasNext();){
	            Element e = (Element)iter.next();  
	            City c = new City();
	            c.setID(e.attributeValue("ID"));
	            c.setCityName(e.attributeValue("CityName"));
	            c.setPID(e.attributeValue("PID"));
	            clist.add(c);
	        }
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			SAXReader reader = new SAXReader();
			Document document = reader.read(new File("C:\\Users\\Administrator\\Desktop\\全国省市区数据库\\Districts.xml"));
			Element root = document.getRootElement();
			dlist = new ArrayList<>();
			for(Iterator iter = root.elementIterator(); iter.hasNext();){
	            Element e = (Element)iter.next();  
	            Districts d = new Districts();
	            d.setID(e.attributeValue("ID"));
	            d.setDistrictName(e.attributeValue("DistrictName"));
	            d.setCID(e.attributeValue("CID"));
	            dlist.add(d);
	        }
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Provinces p : listp) {
			for (City c : clist) {
				for (Districts d : dlist) {
					if(d.getCID().equals(c.getID()) && c.getPID().equals(p.getID())){
						
					}
				}
			}
		}
		
		
	}
}
