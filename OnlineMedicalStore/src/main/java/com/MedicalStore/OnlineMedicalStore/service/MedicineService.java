package com.MedicalStore.OnlineMedicalStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MedicalStore.OnlineMedicalStore.entity.Medicine;
import com.MedicalStore.OnlineMedicalStore.repository.MedicineRepository;

@Service
public class MedicineService {
	@Autowired
	private MedicineRepository bRepo;
public void save(Medicine b){
	bRepo.save(b);
}
public List<Medicine> getAllMedicine(){
	return bRepo.findAll();
}

public Medicine updateMedicineById(int id) {
	return bRepo.findById(id).get();
}
public void deleteById(int id) {
	bRepo.deleteById(id);
}
}
