package io.github.arturtarcisio.mscards.repository;

import io.github.arturtarcisio.mscards.domain.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {

    List<CreditCard> findByIncomeLessThanEqual(BigDecimal income);


}
