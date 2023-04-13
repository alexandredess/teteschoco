
package com.example.api_address.service;

import com.example.api_address.dto.RequestAddressDTO;
import com.example.api_address.dto.ResponseAddressDTO;
import org.springframework.stereotype.Service;

@Service
public interface AddressService {
    //ResponseAddressDTO getAddressById(int id);

    ResponseAddressDTO createAddress(RequestAddressDTO addressDTO);
}
