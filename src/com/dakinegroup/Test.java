package com.dakinegroup;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


public class Test {

	public static void main(String[] args) {
		// simple wiring using bean methods
		Resource resource = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		StoreItem item = (StoreItem)factory.getBean("storeitem1");
		item.displayInfo();
		item = (StoreItem)factory.getBean("storeitem2");
		item.displayInfo();
		
		Store store = (Store)factory.getBean("store1");
		store.displayInfo();
		
		// using application context and aop at the same time
		// note: we are using proxy of store and not the store directly
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Store store1 = (Store) context.getBean("store1Proxy");
		store1.addItem(new StoreItem("A333245"));
		store1.displayInfo();
		System.out.println("--------------");
	}

}
