package com.payment.daofab.repository;

import com.payment.daofab.entity.Child;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChildRepository extends JpaRepository<Child, Long> {
    List<Child> findByParentIdOrderByPaidAmount(Long parentId);
}
