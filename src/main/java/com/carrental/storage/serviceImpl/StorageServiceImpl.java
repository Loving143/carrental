package com.carrental.storage.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carrental.exception.BadRequestException;
import com.carrental.storage.dto.AddStorageRequest;
import com.carrental.storage.model.Storage;
import com.carrental.storage.repository.StorageRepository;
import com.carrental.storage.service.StorageService;

@Service
public class StorageServiceImpl implements StorageService {

	@Autowired
	private StorageRepository storageRepo;
	@Override
	public Storage addStorage(AddStorageRequest request) {
		validateAddStorage(request);
		Storage storage = mapToEntity(request);
        return storageRepo.save(storage);
	}

	@Override
	public Storage updateStorage(Integer id, AddStorageRequest request) {
		 Storage existing = storageRepo.findById(id)
	                .orElseThrow(() -> new BadRequestException("Storage not found"));
		 	validateUpdateStorage(request,id);
	        existing.setName(request.getName());
	        existing.setStorageCode(request.getStorageCode());
	        existing.setLatitude(request.getLatitude());
	        existing.setLongitude(request.getLongitude());
	        existing.setManagerName(request.getManagerName());
	        existing.setContactNumber(request.getContactNumber());
	        existing.setOpeningTime(request.getOpeningTime());
	        existing.setClosingTime(request.getClosingTime());
	        existing.setOperational(request.isOperational());

	        return storageRepo.save(existing);
	}
	
	public void validateAddStorage(AddStorageRequest request){
		 if (storageRepo.existsByStorageCode(request.getStorageCode())) {
	            throw new RuntimeException("Storage code already exists");
	        }
	}
	
	public void validateUpdateStorage(AddStorageRequest request,Integer id) {
		if (!storageRepo.existsByStorageCodeAndIdNot(request.getStorageCode(),id)) {
            throw new RuntimeException("Storage code already exists");
        }
	}

	@Override
	public Storage getStorageById(Integer id) {
	    return storageRepo.findById(id)
                .orElseThrow(() -> new BadRequestException("Storage not found"));
    
	}

	@Override
	public List<Storage> getAllStorages() {
		return storageRepo.findAll();
	}
	
	private Storage mapToEntity(AddStorageRequest request) {
        Storage storage = new Storage();
        storage.setName(request.getName());
        storage.setStorageCode(request.getStorageCode());
        storage.setLatitude(request.getLatitude());
        storage.setLongitude(request.getLongitude());
        storage.setManagerName(request.getManagerName());
        storage.setContactNumber(request.getContactNumber());
        storage.setOpeningTime(request.getOpeningTime());
        storage.setClosingTime(request.getClosingTime());
        storage.setOperational(request.isOperational());
        return storage;
    }

}
