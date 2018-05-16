package cl.seiza.demo.docker.repository;

import cl.seiza.demo.docker.dominio.Usuario;

import java.util.List;

public interface GetUserRepository {
    List<Usuario> getUsuarios(String filtroNombre);
}
