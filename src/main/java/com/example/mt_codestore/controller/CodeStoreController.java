package com.example.mt_codestore.controller;

import com.example.mt_codestore.DTO.CodePoolDTO;
import com.example.mt_codestore.service.CodeStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/codestore")
public class CodeStoreController {
    private final CodeStoreService codeStoreService;

    @Autowired
    public CodeStoreController(CodeStoreService codeStoreService) {
        this.codeStoreService = codeStoreService;
    }

    @GetMapping("/new_for_print")
    public List<CodePoolDTO> getNewForPrint() {
        return codeStoreService.getAllNewForPrinting();
    }
}
