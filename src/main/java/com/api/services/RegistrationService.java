package com.api.services;

import com.api.entity.Registration;
import com.api.exception.ResourceNotFoundException;
import com.api.payload.RegistrationDto;
import com.api.repository.RegistrationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegistrationService {

    private RegistrationRepository registrationRepository;
    private ModelMapper modelMapper;
    public RegistrationService(RegistrationRepository registrationRepository, ModelMapper modelMapper) {
        this.registrationRepository = registrationRepository;
        this.modelMapper = modelMapper;
    }

    public List<RegistrationDto> getRegistrations() {
        List<Registration> registrations = registrationRepository.findAll();
      List<RegistrationDto>dtos= registrations.stream().map(a->mapToDto(a)).collect(Collectors.toList());
        return dtos;
    }

    public RegistrationDto createRegistration(RegistrationDto registrationDto) {
       // copy dto to entity
        Registration registration = mapToEntity(registrationDto );
        Registration savedEntity = registrationRepository.save(registration);
        RegistrationDto Dto = mapToDto( savedEntity);


        return Dto;
    }

    public void deleteReg(Long id) {
        registrationRepository.deleteById(id);
    }

    public RegistrationDto updateRegistration(Long id,RegistrationDto regis){
//name=gdjf,email=jhbfkmv,mobile=7645,

        Registration reg=registrationRepository.findById(id).get();////.get method extract the entity object from optional because findById return type is optiolal that is stored in reg.
            Registration registration= mapToEntity(regis);

        Registration saveUpdate=registrationRepository.save(registration);
        RegistrationDto dto=mapToDto( saveUpdate);
          return dto;
    }
     Registration mapToEntity(RegistrationDto registrationDto) {
       Registration reg= modelMapper.map(registrationDto,Registration.class);
        /* Registration reg=new Registration();
        reg.setName(registrationDto.getName());
        reg.setEmail(registrationDto.getEmail());
        reg.setMobile(registrationDto.getMobile());*/
        return reg;
    }
    RegistrationDto mapToDto(Registration registrations){
     RegistrationDto Dto=  modelMapper.map(registrations,RegistrationDto.class);
       /* RegistrationDto Dto=new RegistrationDto();
        Dto.setName(registrations.getName());
        Dto.setEmail(registrations.getEmail());
        Dto.setMobile(registrations.getMobile());*/
        return Dto;
    }

    public RegistrationDto getRegistrationsById(long id) {
       Registration registration= registrationRepository.findById(id).orElseThrow(
               ()-> new ResourceNotFoundException("Data Not Present !")
       );
       return mapToDto(registration);
    }
}