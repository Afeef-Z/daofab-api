package com.payment.daofab.service;

import com.payment.daofab.dto.ChildDTO;
import com.payment.daofab.entity.Child;
import com.payment.daofab.repository.ChildRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChildService {
    private final ChildRepository childRepository;

    public ChildService(ChildRepository childRepository) {
        this.childRepository = childRepository;
    }

    public List<ChildDTO> findChildrenByParentId(Long parentId) {
        return childRepository.findByParentIdOrderByPaidAmount(parentId)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private ChildDTO convertToDTO(Child child) {
     return ChildDTO.builder()
             .id(child.getId())
             .paidAmount(child.getPaidAmount())
             .sender(child.getParent().getSender())
             .receiver(child.getParent().getReceiver())
             .totalAmount(child.getParent().getTotalAmount())
             .parentId(child.getParent().getId())
             .build();
    }
}


