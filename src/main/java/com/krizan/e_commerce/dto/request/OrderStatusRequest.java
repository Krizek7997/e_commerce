package com.krizan.e_commerce.dto.request;

import com.krizan.e_commerce.utils.OrderStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderStatusRequest {

    OrderStatus status;
}
