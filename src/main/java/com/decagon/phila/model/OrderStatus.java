package com.decagon.phila.model;

import lombok.Getter;

@Getter
public enum OrderStatus {
    DELIVERED,
    CANCELLED,
    PENDING,
    REFUNDED
}
