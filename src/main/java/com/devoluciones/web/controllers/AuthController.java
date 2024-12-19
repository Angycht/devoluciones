package com.devoluciones.web.controllers;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devoluciones.services.UsuarioService;
import com.devoluciones.services.dtos.LoginDTO;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/auth")

public class AuthController {

    @Autowired
    private UsuarioService usuarioService;
    
    
    @PostMapping("/login")
    public ResponseEntity<java.util.Map<String, String>> login(@RequestBody LoginDTO loginRequest) {
        boolean isAuthenticated = usuarioService.autenticarUsuario(loginRequest.getCorreo(), loginRequest.getContrasenia());

        if (isAuthenticated) {
            return ResponseEntity.ok().build();
        } else {
            java.util.Map<String, String> response = new HashMap<>();
            response.put("message", "Credenciales inválidas");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }
}
