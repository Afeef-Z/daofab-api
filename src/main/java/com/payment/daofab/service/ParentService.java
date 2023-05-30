package com.payment.daofab.service;

import com.payment.daofab.dto.ParentDTO;
import com.payment.daofab.repository.ParentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ParentService {

    private final ParentRepository parentRepository;

    public ParentService(ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }

    public Page<ParentDTO> findParentsWithTotalPaidAmount(Pageable pageable) {
        return parentRepository.findParentTransactionsWithTotalPaidAmount(pageable);
    }

}

