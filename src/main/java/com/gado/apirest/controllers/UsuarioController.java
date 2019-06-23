package com.gado.apirest.controllers;

import com.gado.apirest.models.Usuario;
import com.gado.apirest.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/usuario")
    public Usuario salvaUsuario(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
}
