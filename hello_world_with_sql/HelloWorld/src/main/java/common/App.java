package common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import road.to.cto.HelloWorld.custom.dao.CustomerDAO;
import road.to.cto.HelloWorld.custom.model.Customer;

public class App {

    public App() {
        // TODO Auto-generated constructor stub
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ApplicationContext context = 
                new ClassPathXmlApplicationContext("Spring-Module.xml");
     
            CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDAO");
            Customer customer = new Customer(2, "hugo",30);
            customerDAO.insert(customer);
     
            Customer customer1 = customerDAO.findByCustomerId(1);
            System.out.println(customer1);
    }

}
