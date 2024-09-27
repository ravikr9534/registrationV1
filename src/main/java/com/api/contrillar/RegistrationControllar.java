package com.api.contrillar;

import com.api.entity.Registration;
import com.api.payload.RegistrationDto;
import com.api.repository.RegistrationRepository;
import com.api.services.RegistrationService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/registration")
public class RegistrationControllar {
    private RegistrationService registrationService;

    private RegistrationDto registrationDto;
    public RegistrationControllar(RegistrationService registrationService
                               ) {
        this.registrationService = registrationService;


    }

    @GetMapping
    public ResponseEntity< List<RegistrationDto>> getAllregistrations (){
        List<RegistrationDto>Dtos=registrationService.getRegistrations();
        return new ResponseEntity<>(Dtos, HttpStatus.OK);

    }
    @PostMapping
    public  ResponseEntity<?> createRegistration(
           @Valid @RequestBody RegistrationDto registrationDto,
           BindingResult result
    ){
        if(result.hasErrors()){
        return new ResponseEntity<>(result.getFieldError().getDefaultMessage(),HttpStatus.CREATED);
    }
   RegistrationDto regDto= registrationService.createRegistration(registrationDto);
           return new ResponseEntity<>(regDto,HttpStatus.CREATED);
    }
    @DeleteMapping
    public ResponseEntity<String>deleteRegistration(
            @RequestParam Long id
    ){
        registrationService.deleteReg(id);
        return  new ResponseEntity<>("deleted",HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity <RegistrationDto> updateRegistrationById(@PathVariable Long id,@RequestBody RegistrationDto reg){
        RegistrationDto regs=registrationService.updateRegistration(id,reg);
        return  new ResponseEntity<>(regs,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<RegistrationDto> getRegistrationById(@PathVariable long id){
      RegistrationDto dto= registrationService.getRegistrationsById(id);
        return new ResponseEntity<>(dto,HttpStatus.OK);

    }

}
