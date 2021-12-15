package kg.itschool.megashop.service.impl;

import kg.itschool.megashop.config.CodeGenerator;
import kg.itschool.megashop.mapper.AccountMapper;
import kg.itschool.megashop.mapper.AddressMapper;
import kg.itschool.megashop.mapper.CustomerMapper;
import kg.itschool.megashop.model.dto.AccountDto;
import kg.itschool.megashop.model.dto.AddressDto;
import kg.itschool.megashop.model.dto.CustomerDto;
import kg.itschool.megashop.model.entity.Customer;
import kg.itschool.megashop.model.request.CreateCustomerRequest;
import kg.itschool.megashop.repository.CustomerRepository;
import kg.itschool.megashop.service.AddressService;
import kg.itschool.megashop.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final AddressService addressService;

    @Qualifier("getDigitsGenerator")
    private final CodeGenerator accountNumberGenerator;

    @Override
    public CustomerDto create(CreateCustomerRequest request) {
        if (customerRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("Customer with email=" + request.getEmail() + " is already exists");
        }
        if (customerRepository.existsByPhoneNumber(request.getPhoneNumber())) {
            throw new IllegalArgumentException("Customer with phoneNumber=" + request.getPhoneNumber() + " is already exists");
        }

        AddressDto addressDto = addressService.create(request.getAddress());
        AccountDto accountDto = AccountDto
                .builder()
                .availableFunds(BigDecimal.ZERO)
                .accountNumber(accountNumberGenerator.nextString())
                .build();

        CustomerDto customerDto = CustomerDto
                .builder()
                .account(accountDto)
                .address(addressDto)
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .build();

        customerRepository.save(CustomerMapper.INSTANCE.toEntity(customerDto));

        return customerDto;
    }

    @Override
    public CustomerDto find(Long id) {
        Customer customer = customerRepository.findByIdAndIsDeletedFalse(id) // null
                .orElseThrow(() -> new RuntimeException("Customer with id=" + id + " not found."));

        return CustomerMapper.INSTANCE.toDto(customer);
    }

    @Override
    public void update(CustomerDto customerDto) {
        customerRepository.findByIdAndIsDeletedFalse(customerDto.getId()).map(customer -> {
            customer.setEmail(customerDto.getEmail());
            customer.setAccount(AccountMapper.INSTANCE.toEntity(customerDto.getAccount()));
            customer.setAddress(AddressMapper.INSTANCE.toEntity(customerDto.getAddress()));
            customer.setPhoneNumber(customerDto.getPhoneNumber());

            return customerRepository.save(customer);
        });
    }

    @Override
    public void delete(Long id) {
        customerRepository.findByIdAndIsDeletedFalse(id).map(customer -> {
            customer.setIsDeleted(true);
            return customerRepository.save(customer);
        });
    }
}
