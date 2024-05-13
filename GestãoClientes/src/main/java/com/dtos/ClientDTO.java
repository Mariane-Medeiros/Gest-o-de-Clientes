package com.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ClientDTO(
		 @NotBlank String nome,
		 @Email String email,
		 String telefone,
		 @NotBlank String nomeUsuario,
		 @Size(min = 7)String senha
		) {

}
