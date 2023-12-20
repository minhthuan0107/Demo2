package repository;

import entity.CustomerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<CustomerEntity, Integer> {
    List<CustomerEntity> findAllBySexAndBirthdateBetween(String sex, LocalDate minbirthdate, LocalDate maxbirthdate);
    CustomerEntity findByName(String name);
    List<CustomerEntity> findByPhoneOrEmail(Long phone, String email);
}
