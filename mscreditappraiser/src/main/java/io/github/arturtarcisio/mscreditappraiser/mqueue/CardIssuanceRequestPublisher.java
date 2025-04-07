package io.github.arturtarcisio.mscreditappraiser.mqueue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.arturtarcisio.mscreditappraiser.dto.CardIssuanceRequestData;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CardIssuanceRequestPublisher {

    private final RabbitTemplate rabbitTemplate;
    private final Queue queueCardIssuance;

    public void requestCard(CardIssuanceRequestData data) throws JsonProcessingException {
        var json = convertIntoJson(data);
        rabbitTemplate.convertAndSend(queueCardIssuance.getName(), json);
    }

    private String convertIntoJson(CardIssuanceRequestData data) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(data);
    }
}
