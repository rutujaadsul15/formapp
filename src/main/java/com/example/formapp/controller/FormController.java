package com.example.formapp.controller;

import com.example.formapp.model.FormData;
import com.example.formapp.service.FormServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/formoperation")
public class FormController {
    @Autowired
    private FormServiceImpl formServiceImpl;


    @PostMapping("/insert")
    public String insertData(@RequestBody FormData formData) {
        formServiceImpl.insertRecord(formData);
        return "success";
    }

    @GetMapping("/getallrecords")
    public List<FormData> getAllRecord() {
        return formServiceImpl.getAllRecord();
    }

    @GetMapping("/getrecordbyid/{id}")
    public FormData getRecordById(@PathVariable("id") Integer id) {
       return formServiceImpl.getRecordById(id);
    }
    @GetMapping("/getrecordbyphoneNumber/{phoneNumber}")
    public FormData getRecordByPhoneNumber(@PathVariable("phoneNumber") String phoneNumber) {
        return formServiceImpl.getRecordByPhoneNumber(phoneNumber);
    }
    @DeleteMapping ("/deleterecordbyid/{id}")
    public String deleteRecordById(@PathVariable("id") Integer id) {
         formServiceImpl.deleteRecordById(id);
         return "record deleted";
    }

    @PutMapping("/updaterecords/{id}")
    public String updateRecordById(@RequestBody FormData formData , @PathVariable("id") Integer id) {
        formServiceImpl.updateRecordById(formData, id);
        return "updated successfully";
    }
}
