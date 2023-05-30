package com.payment.daofab.repository;

import com.payment.daofab.dto.ParentDTO;
import com.payment.daofab.entity.Parent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ParentRepository extends JpaRepository<Parent, Long> {
    @Query("SELECT new com.payment.daofab.dto.ParentDTO(p.id, p.sender, p.receiver, p.totalAmount, SUM(c.paidAmount)) FROM Parent p LEFT JOIN p.childList c GROUP BY p")
    Page<ParentDTO> findParentTransactionsWithTotalPaidAmount(Pageable pageable);

}
