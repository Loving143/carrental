package com.carrental.storage.service;

import java.util.List;

import com.carrental.storage.dto.AddStorageRequest;
import com.carrental.storage.model.Storage;

public interface StorageService {

	Storage addStorage(AddStorageRequest request);
    Storage updateStorage(Integer id, AddStorageRequest request);
    Storage getStorageById(Integer id);
    List<Storage> getAllStorages();
}
