package com.example.formapp.service;

import com.example.formapp.model.FormData;
import com.example.formapp.repository.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FormServiceImpl implements FormService {

    @Autowired
    private FormRepository formRepository;

    @Override
    public void insertRecord(FormData formData) {
        System.out.println("This is insert record method");
        System.out.println(formData);
        formRepository.save(formData);

    }

    @Override
    public List<FormData> getAllRecord() {
        List<FormData> formDataList = new ArrayList<>();
        formDataList = formRepository.findAll();
        return formDataList;
    }

    @Override
    public FormData getRecordById(Integer id) {
        Optional<FormData> formDataOptional = formRepository.findById(id);
        if (formDataOptional.isPresent()) {
            return formDataOptional.get();
        } else
            throw new RuntimeException("Record Not Found");
    }

    @Override
    public FormData getRecordByPhoneNumber(String phoneNumber) {
        List<FormData> formDataList = formRepository.findAll();
        Optional<FormData> formDataOptional = formDataList.stream().filter(formData -> formData.getPhoneNo().equals(phoneNumber)).findAny();
        if (formDataOptional.isPresent()) {
            return formDataOptional.get();
        } else
            throw new RuntimeException("No Record Found for given phone number");
    }

    @Override
    public void deleteRecordById(Integer id) {
        try {
            formRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("something is wrong while deleting record" + e.getMessage());
        }


    }

    @Override
    public FormData updateRecordById(FormData inputFormData ,Integer id) {

        if (formRepository.findById(id).isPresent()) {
            FormData formDataOfDb= formRepository.findById(id).get();

            formDataOfDb.setFname(inputFormData.getFname());
            formDataOfDb.setLname(inputFormData.getLname());
            formDataOfDb.setAge(inputFormData.getAge());
            formDataOfDb.setEmail(inputFormData.getEmail());
            formDataOfDb.setPhoneNo(inputFormData.getPhoneNo());

            return formRepository.save(formDataOfDb);

        } else {
           throw new RuntimeException("Record not found");
        }

    }
}
