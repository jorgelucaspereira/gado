package com.gado.apirest.controller;

import com.gado.apirest.models.Usuario;
import com.gado.apirest.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/gado")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("/usuarios")
    public List<Usuario> listaUsuario(){
        return usuarioRepository.findAll();
    }

    @GetMapping("/usuario/{id}")
    public Usuario listaUsuarioUnico(@PathVariable(value = "id") long id){
        return usuarioRepository.findById(id);
    }
}
