package com.example.barbearia.services;

import com.example.barbearia.dto.RegisterUserDTO;
import com.example.barbearia.models.Usuario;
import com.example.barbearia.repository.UsuarioREPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    UsuarioREPO userRepo;
    public Usuario registrar(RegisterUserDTO user){
        String pass = user.getSenha();
        String email = user.getEmail();
        return userRepo.save(new Usuario(email,new BCryptPasswordEncoder().encode(pass)));
    }

}
