package com.gado.apirest.controller;

import com.gado.apirest.model.Usuario;
import com.gado.apirest.repository.UsuarioRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/gado")
@Api(value = "API REST Gados")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("/usuarios")
    @ApiOperation(value = "Retorna uma lista de 'Usuários'")
    public List<Usuario> listaUsuarios() {
        return usuarioRepository.findAll();
    }

    @GetMapping("/usuario/{id}")
    @ApiOperation(value = "Retorna um único 'Usuário', passando um id como parâmetro")
    public Usuario listaUsuarioUnico(@PathVariable(value = "id") long id) {
        return usuarioRepository.findById(id);
    }

    @PostMapping("/usuario")
    @ApiOperation(value = "Salva um 'Usuário'")
    public Usuario salvaUsuario(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @DeleteMapping("/usuario")
    @ApiOperation(value = "Deleta um 'Usuário'")
    public void deletaUsuario(@RequestBody Usuario usuario) {
        usuarioRepository.delete(usuario);
    }

    @PutMapping("/usuario")
    @ApiOperation(value = "Atualiza um 'Usuário'")
    public Usuario atualizaUsuario(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
}
