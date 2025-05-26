package com.carrental.storage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carrental.storage.dto.AddStorageRequest;
import com.carrental.storage.model.Storage;
import com.carrental.storage.service.StorageService;

@RestController
@RequestMapping("/admin/storage")
@PreAuthorize("hasRole('ADMIN')")
public class StorageController {

    @Autowired
    private StorageService storageService;

    @PostMapping("/add")
    public ResponseEntity<Storage> addStorage(@RequestBody AddStorageRequest request) {
        return ResponseEntity.ok(storageService.addStorage(request));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Storage> updateStorage(@PathVariable Integer id,@RequestBody AddStorageRequest request) {
        return ResponseEntity.ok(storageService.updateStorage(id, request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Storage> getStorageById(@PathVariable Integer id) {
        return ResponseEntity.ok(storageService.getStorageById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Storage>> getAllStorages() {
        return ResponseEntity.ok(storageService.getAllStorages());
    }
}