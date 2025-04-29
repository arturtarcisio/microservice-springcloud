package io.github.arturtarcisio.mscards.mqueue;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.arturtarcisio.mscards.domain.CreditCard;
import io.github.arturtarcisio.mscards.domain.CustomerCreditCard;
import io.github.arturtarcisio.mscards.dto.CardIssuanceRequestData;
import io.github.arturtarcisio.mscards.repository.CreditCardRepository;
import io.github.arturtarcisio.mscards.repository.CustomerCreditCardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class CardIssuanceSubscriber {

    private final CreditCardRepository creditCardrepository;
    private final CustomerCreditCardRepository customerCreditCardRepository;

    @RabbitListener(queues = "${mq.queues.emissao-cartoes}")
    public void receiveIssuanceRequest(@Payload String payload){
        var mapper = new ObjectMapper();
        try {
            CardIssuanceRequestData data = mapper.readValue(payload, CardIssuanceRequestData.class);
            CreditCard creditCard = creditCardrepository.findById(data.getCreditCardId()).orElseThrow();
            var customerCreditCard = CustomerCreditCard.builder()
                    .id(data.getCreditCardId())
                    .cpf(data.getCpf())
                    .creditCard(creditCard)
                    .creditLimit(creditCard.getLimitCredit())
                    .build();
            customerCreditCardRepository.save(customerCreditCard);
        } catch (Exception e) {
            log.error("Error receiving card issuance request: {}", e.getMessage());
        }
    }
}
