package projeto_web_spring_angular.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projeto_web_spring_angular.model.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
