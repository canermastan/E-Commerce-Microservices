package com.canermastan.inventoryservice.controller;

import com.canermastan.inventoryservice.dto.InventoryResponse;
import com.canermastan.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping
    public ResponseEntity<List<InventoryResponse>> isInStock(@RequestParam List<String> skuCode) {
        List<InventoryResponse> inventoryResponse = inventoryService.isInStock(skuCode);

        if (inventoryResponse.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(inventoryResponse);
        } else {
            return ResponseEntity.ok(inventoryResponse);
        }
    }
}
