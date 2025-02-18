package io.github.arturtarcisio.mscustomers.infra.repository;

import io.github.arturtarcisio.mscustomers.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByCpf(String cpf);
}
