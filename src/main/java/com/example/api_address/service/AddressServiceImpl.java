package com.example.api_address.service;

import com.example.api_address.dto.RequestAddressDTO;
import com.example.api_address.dto.ResponseAddressDTO;
import com.example.api_address.entity.Address;
import com.example.api_address.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

@Service
public class AddressServiceImpl implements  AddressService {
    @Autowired
    private AddressRepository _repository;

    private ModelMapper _modelMapper;

    public  AddressServiceImpl( ModelMapper _modelMapper){
        this._modelMapper=_modelMapper;
    }

   /* @Override
    public  ResponseAddressDTO getAddressById(int id){
        return _modelMapper.map(findAddress(id), ResponseAddressDTO.class);
    }*/
    @Override
    public ResponseAddressDTO createAddress(RequestAddressDTO addressDTO){

        Address address = _modelMapper.map(addressDTO, Address.class);
         address = _repository.save(address);
        ResponseAddressDTO responseAddressDTO= _modelMapper.map(address,ResponseAddressDTO.class);

        return responseAddressDTO;
    }

    Address findAddress(int id){
        Address address = _repository.findById(id).get();
        return  address;
    }
}
