package com.carrental.storage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carrental.storage.model.Storage;

public interface StorageRepository extends JpaRepository<Storage, Integer>{

	boolean existsByStorageCode(String storageCode);

	boolean existsByStorageCodeAndIdNot(String storageCode, Integer id);

}
