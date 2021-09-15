package util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static StandardServiceRegistry registry;
	private static SessionFactory sessionFactory;
	public static SessionFactory getSessionFactory(){
		if(sessionFactory==null){
			System.out.println("in getSessionFactory");
			
		//	Configuration config=new Configuration();
		//	config.configure("hibernate.cfg.xml");
		//	config.addResource(resourceName)
			System.out.println("at Config");
			StandardServiceRegistryBuilder registryBuilder=new StandardServiceRegistryBuilder();
			registry=registryBuilder.configure("hibernate.cfg.xml").build();
			System.out.println("at Registry");
			
			Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
			//registry=new StandardServiceRegistryBuilder().configure().build();
			//MetadataSources sources=new MetadataSources();
			//Metadata metadata = sources.getMetadataBuilder().build();
			//System.out.println("at Metadata");
			//sessionFactory=metadata.getSessionFactoryBuilder().build();
			sessionFactory= metadata.getSessionFactoryBuilder().build();
			System.out.println("at metadata sessionfactory");
		}
		return sessionFactory;
	}
	
	public static void shutdown(){
		if(registry!=null){
			StandardServiceRegistryBuilder.destroy(registry);
			System.out.println("at null registry");
		}
	}

}
