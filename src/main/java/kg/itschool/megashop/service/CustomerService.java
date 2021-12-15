package kg.itschool.megashop.service;

import kg.itschool.megashop.model.dto.CustomerDto;
import kg.itschool.megashop.model.request.CreateCustomerRequest;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {

    CustomerDto create(CreateCustomerRequest request);
    CustomerDto find(Long id);
    void update(CustomerDto customerDto);
    void delete(Long id);

}
