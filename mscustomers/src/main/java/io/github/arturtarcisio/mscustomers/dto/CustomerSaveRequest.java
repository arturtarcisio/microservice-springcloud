package io.github.arturtarcisio.mscustomers.dto;

import io.github.arturtarcisio.mscustomers.domain.Customer;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomerSaveRequest {
    private String cpf;
    private Integer age;
    private String name;

    public Customer toModel() {
        return new Customer(this.cpf, this.name, this.age);
    }
}
