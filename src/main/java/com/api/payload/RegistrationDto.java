package com.api.payload;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter


public class RegistrationDto {


    @Size(min=2,message="ka re ladewa 2 letter daal kam se kam")
    private String name;

   @Email
    private String email;
   @NotEmpty
    @Size(min=10,max=10,message="mobile number dalo ladwa nahi")
    private String mobile;


}