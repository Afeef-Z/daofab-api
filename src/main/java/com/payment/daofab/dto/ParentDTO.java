package com.payment.daofab.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ParentDTO {

    private Long parentId;
    private String sender;
    private String receiver;
    private Double totalAmount;
    private Double totalPaidAmount;


}
