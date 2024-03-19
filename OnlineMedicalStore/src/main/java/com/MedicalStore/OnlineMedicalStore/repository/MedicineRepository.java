package com.MedicalStore.OnlineMedicalStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MedicalStore.OnlineMedicalStore.entity.Medicine;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine,Integer> {

}
