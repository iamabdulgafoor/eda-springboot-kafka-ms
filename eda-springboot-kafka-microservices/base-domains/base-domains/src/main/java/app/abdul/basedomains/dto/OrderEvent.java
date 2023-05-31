package app.abdul.basedomains.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEvent implements Serializable {
    private String orderMessage;
    private String orderStatus;
    private OrderDto order;
}
