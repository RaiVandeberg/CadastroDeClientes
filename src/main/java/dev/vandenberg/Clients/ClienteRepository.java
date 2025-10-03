package dev.vandenberg.Clients;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<ClienteModel,Long> {
    List<ClienteModel> id(Long id);
}
