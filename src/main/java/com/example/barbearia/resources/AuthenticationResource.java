package com.example.barbearia.resources;

import com.example.barbearia.dto.CheckUserDTO;
import com.example.barbearia.dto.RegisterUserDTO;
import com.example.barbearia.jwt.JwtTokenUtil;
import com.example.barbearia.models.Usuario;
import com.example.barbearia.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthenticationResource {

    @Autowired AuthenticationManager authManager;
    @Autowired JwtTokenUtil jwtUtil;
    @Autowired AuthService authService;
    public AuthenticationResource(AuthenticationManager authenticationManager,
                        JwtTokenUtil jwtTokenUtil) {
        this.authManager = authenticationManager;
        this.jwtUtil = jwtTokenUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody RegisterUserDTO request){
        try {
            UsernamePasswordAuthenticationToken usernamePasswordAuthToken =
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getSenha());
            Authentication authentication = authManager.authenticate(usernamePasswordAuthToken);
            Usuario user = (Usuario) authentication.getPrincipal();
            String token =  jwtUtil.generateAcessToken(user);
            CheckUserDTO response = new CheckUserDTO(user.getEmail(), token);
            return ResponseEntity.ok(response);
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping("/register")
    public ResponseEntity<Usuario> register(@RequestBody RegisterUserDTO request){
            Usuario usuario = authService.registrar(request);
            return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
