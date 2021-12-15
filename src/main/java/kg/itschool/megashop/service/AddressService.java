package kg.itschool.megashop.service;

import kg.itschool.megashop.model.dto.AddressDto;
import org.springframework.stereotype.Service;

@Service
public interface AddressService {

    AddressDto find(Long id);
    AddressDto create(AddressDto addressDto);

}
