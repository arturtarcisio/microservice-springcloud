package io.github.arturtarcisio.mscreditappraiser.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreditRatingResponse {

    private List<CreditCardApproved> creditCardsApproved;
}
