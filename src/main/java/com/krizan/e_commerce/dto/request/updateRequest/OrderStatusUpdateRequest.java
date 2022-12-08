package com.krizan.e_commerce.dto.request.updateRequest;

import com.krizan.e_commerce.utils.OrderStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderStatusUpdateRequest {

    private OrderStatus status;
}
