package dev.vandenberg.Dependentes;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DependenteRepository extends JpaRepository<DependenteModel, Long> {
    List<DependenteModel> id(Long id);
}
