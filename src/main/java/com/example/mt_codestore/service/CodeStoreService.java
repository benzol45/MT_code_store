package com.example.mt_codestore.service;

import com.example.mt_codestore.DAO.CodeStoreDAO;
import com.example.mt_codestore.DTO.CodePoolDTO;
import com.example.mt_codestore.entity.Code;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CodeStoreService {
    private final CodeStoreDAO codeStoreDAO;

    public CodeStoreService(CodeStoreDAO codeStoreDAO) {
        this.codeStoreDAO = codeStoreDAO;
    }

    public List<CodePoolDTO> getAllNewForPrinting() {
        List<Code> codesFromDB = codeStoreDAO.getForPrint();
        List<CodePoolDTO> listForSend = codesFromDB
                .stream().collect(Collectors.toMap(
                        code -> Map.of("orderId",code.getOrderId(),"productGTIN",code.getProductGTIN()),
                        code -> {
                            List list = new ArrayList<String>();
                            list.add(code.getMarkCode());
                            return list;
                        },
                        (o, o2) -> {
                            o.addAll(o2);
                            return o;
                        }))
                .entrySet().stream()
                .map(codePool -> new CodePoolDTO(
                        (Long)codePool.getKey().get("orderId"),
                        (String)codePool.getKey().get("productGTIN"),
                        codePool.getValue()))
                .toList();


        List<String> codes = codesFromDB.stream().map(code -> code.getMarkCode()).toList();
        codeStoreDAO.setSentForPrint(codes);

        return listForSend;
    }
}
