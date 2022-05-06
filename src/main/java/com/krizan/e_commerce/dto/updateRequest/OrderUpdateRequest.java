package com.krizan.e_commerce.dto.updateRequest;

import com.krizan.e_commerce.utils.OrderStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderUpdateRequest {

    private OrderStatus status;
}
