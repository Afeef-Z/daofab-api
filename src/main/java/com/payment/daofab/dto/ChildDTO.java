package com.payment.daofab.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ChildDTO {
    private Long id;
    private Long parentId;
    private String sender;
    private String receiver;
    private Double totalAmount;
    private Double paidAmount;

}
