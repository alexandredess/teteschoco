package com.example.api_address;

import com.example.api_address.dto.RequestAddressDTO;
import com.example.api_address.dto.ResponseAddressDTO;
import com.example.api_address.entity.Address;
import com.example.api_address.repository.AddressRepository;
import com.example.api_address.service.AddressServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class CrudAddressTest {
    /* exemple d'un test simple
    @Test
    void apprentissage(){

        //Arrange
        //int a = 5;
        //int b = 2;
        AddressController addressController = new AddressController();
        //Act
        int result =  addressController.calcul(3,2);
        //Assert
        Assertions.assertEquals(5,result);

    }*/
    @Mock
    AddressRepository addressRepository;
    @Spy
    ModelMapper modelMapper;


    @InjectMocks
    private AddressServiceImpl addressService;

    private Address address;
    private RequestAddressDTO dto;
    @Test
    void TestAddressCreate() throws  Exception{
        address=new Address();
        address.setNumStreet(33);
        address.setNameStreet("bidon");
        address.setCity("bethune");
        dto = new RequestAddressDTO();
        dto.setStreet("bidon");
        dto.setCity("bethune");
        given(addressRepository.save(any())).willReturn(address);

        ResponseAddressDTO sav = addressService.createAddress(dto);

        assertThat(sav).isNotNull();
     }
/*

    @Test
    void TestAddressRead(){

    }
    @Test
    void  TestAddressUpdate(){

    }
    @Test
    void  TestAddressDelete(){

    }*/
}
