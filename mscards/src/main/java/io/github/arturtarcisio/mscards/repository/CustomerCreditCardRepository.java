package io.github.arturtarcisio.mscards.repository;

import io.github.arturtarcisio.mscards.domain.CustomerCreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerCreditCardRepository extends JpaRepository<CustomerCreditCard, Long> {

    List<CustomerCreditCard> findByCpf(String cpf);

}
