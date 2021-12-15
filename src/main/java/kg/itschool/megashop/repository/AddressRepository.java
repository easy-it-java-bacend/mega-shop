package kg.itschool.megashop.repository;

import kg.itschool.megashop.model.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    Optional<Address> findByStateAndCityNameAndRegionAndStreetNameAndStreetNameOptionalAndHouseAndPostalCode(String state,
                                                                                                             String region,
                                                                                                             String cityName,
                                                                                                             String streetName,
                                                                                                             String streetNameOptional,
                                                                                                             String house,
                                                                                                             String postalCode);
}
