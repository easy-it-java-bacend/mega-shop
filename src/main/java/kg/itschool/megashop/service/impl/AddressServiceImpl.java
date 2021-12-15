package kg.itschool.megashop.service.impl;

import kg.itschool.megashop.mapper.AddressMapper;
import kg.itschool.megashop.model.dto.AddressDto;
import kg.itschool.megashop.model.entity.Address;
import kg.itschool.megashop.repository.AddressRepository;
import kg.itschool.megashop.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    @Override
    public AddressDto find(Long id) {
        return null;
    }

    @Override
    public AddressDto create(AddressDto addressDto) {
        Address address = addressRepository
                .findByStateAndCityNameAndRegionAndStreetNameAndStreetNameOptionalAndHouseAndPostalCode(
                        addressDto.getState(),
                        addressDto.getCityName(),
                        addressDto.getRegion(),
                        addressDto.getStreetName(),
                        addressDto.getStreetNameOptional(),
                        addressDto.getHouse(),
                        addressDto.getPostalCode())
                .orElseGet(() -> addressRepository.save(AddressMapper.INSTANCE.toEntity(addressDto)));
        addressDto.setId(address.getId());
        return addressDto;
    }
}
