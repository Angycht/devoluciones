package com.devoluciones.services.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoginDTO {

	 private String correo;
	 private String contrasenia;
}
