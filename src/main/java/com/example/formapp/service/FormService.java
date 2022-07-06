package com.example.formapp.service;

import com.example.formapp.model.FormData;

import java.util.List;

public interface FormService {
    public void insertRecord(FormData formData);

    List<FormData> getAllRecord();

    FormData getRecordById(Integer id);


    FormData getRecordByPhoneNumber(String phoneNumber);

    void deleteRecordById(Integer id);

    FormData updateRecordById(FormData formData ,Integer id);
}




