package demo;
import config.Springconfig;
import entity.CustomerEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import repository.CustomerRepository;

import java.time.LocalDate;
import java.util.List;

public class MainTest {
    static ApplicationContext context = new AnnotationConfigApplicationContext(Springconfig.class);
    static CustomerRepository customerRepository =(CustomerRepository) context.getBean("customerRepository");

    private static  void createNewBook(){
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setName("Minh");
        customerEntity.setBirthdate(LocalDate.parse("2002-07-01"));
        customerEntity.setSex("male");
        customerEntity.setEmail("thuanminh@gmail.com");
        customerEntity.setPhone(0124234L);
        customerEntity.setAddress("HaNoi");

        CustomerEntity result = customerRepository.save(customerEntity);
        if(result!= null){
            System.out.println("Customer thêm thành công, bookID="+customerEntity.getId());
        }
    }

    public static void main(String[] args) {
        //findall
        List<CustomerEntity> customerEntities = (List<CustomerEntity>) customerRepository.findAll();
        for (CustomerEntity customerEntity2 : customerEntities) {
            System.out.println("ListFindAll:" + customerEntity2.toString());
        }
        //fyById
        CustomerEntity customer = (CustomerEntity) customerRepository.findById(1).orElse(null);
        System.out.println("Find by id:" + customer.toString());

        //fyByName
        CustomerEntity customer1 = (CustomerEntity) customerRepository.findByName("Thuận");
        System.out.println("Find by name"+customer1.toString());
        //findByePhoneOrMail
        List<CustomerEntity> customer2 = (List<CustomerEntity>) customerRepository.findByPhoneOrEmail(1L,"thuanminhle0107@gmail.com");
        System.out.println("Find by phoneoremail"+customer2.toString());
       //findAllBySexAndAgeBetween
        List<CustomerEntity> customer3 = (List<CustomerEntity>) customerRepository.findAllBySexAndBirthdateBetween("male",LocalDate.parse("1993-01-07"),LocalDate.parse("2023-01-07"));
        System.out.println("find Al lBy Sex And AgeBetween"+customer3.toString());


    }
    }

