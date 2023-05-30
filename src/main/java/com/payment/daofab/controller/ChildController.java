package com.payment.daofab.controller;

import com.payment.daofab.dto.ChildDTO;
import com.payment.daofab.service.ChildService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/child")
public class ChildController {
    private final ChildService childService;

    public ChildController(ChildService childService) {
        this.childService = childService;
    }

    @GetMapping("/{parentId}")
    public ResponseEntity<List<ChildDTO>> getChildrenByParentId(@PathVariable Long parentId) {
        List<ChildDTO> children = childService.findChildrenByParentId(parentId);
        return ResponseEntity.ok(children);
    }
}