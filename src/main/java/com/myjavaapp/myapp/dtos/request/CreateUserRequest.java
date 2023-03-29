package com.myjavaapp.myapp.dtos.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class CreateUserRequest {
    @NotEmpty(message = "Kullanıcı adı boş olamaz.")
    @Size(min = 3, max = 20, message = "Kullanıcı adı 3-20 karakter arasında olmalıdır.")
    private String username;

    @Email(message = "Geçerli bir e-posta adresi giriniz.")
    private String email;

    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$",
            message = "Parola en az 8 karakter, bir büyük harf, bir küçük harf ve bir sayı içermelidir.")
    private String password;

    // getter/setter metodları
}