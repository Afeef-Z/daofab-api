package com.payment.daofab.controller;

import com.payment.daofab.dto.ParentDTO;
import com.payment.daofab.service.ParentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/parent")
public class ParentController {

    private final ParentService parentService;

    public ParentController(ParentService parentService) {
        this.parentService = parentService;
    }

    @GetMapping
    public ResponseEntity<Page<ParentDTO>> getAllTransactions(Pageable pageable) {
        Page<ParentDTO> transactions = parentService.findParentsWithTotalPaidAmount(pageable);
        return ResponseEntity.ok(transactions);
    }

}
