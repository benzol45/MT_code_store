package com.example.mt_codestore.DAO;

import com.example.mt_codestore.entity.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class CodeStoreDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CodeStoreDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addCode(String markCode, String productGTIN, long orderId, String orderUUID) {
        //language=sql
        String query = "INSERT INTO code(mark_code, product_gtin, order_id, order_uuid, sent_for_print, sent_for_apply, applied, sale) " +
                "VALUES (?,?,?,?,false,false,false,false)";
        int numberOfAddedRows = jdbcTemplate.update(query, markCode, productGTIN, orderId, orderUUID);
        if (numberOfAddedRows!=1) {
            throw new IllegalStateException("Can't add code to database");
        }
    }

    public List<Code> getForPrint() {
        //language=sql
        String query = "SELECT * FROM code WHERE sent_for_print=false";
        return jdbcTemplate.query(query, new CodeRowMapper());
    }

    public void setSentForPrint(List<String> codes) {
        //language=sql
        String query = "UPDATE code SET sent_for_print=true WHERE mark_code IN (#ListOfCodes)";
        //Some DBMS can't process very long parameters. If in list are over 100 codes we process they in parts of 100.
        if (codes.size()<=100) {
            query = query.replace("#ListOfCodes", codes.stream().collect(Collectors.joining("', '", "'", "'")));
            jdbcTemplate.update(query);
        } else {
            for (int i = 0; i < codes.size() / 100 + 1; i++) {
                int start = i * 100;
                int end = Math.min((i + 1) * 100, codes.size());
                List<String> currentPart = codes.subList(start, end);
                String param = currentPart.stream().collect(Collectors.joining("', '", "'", "'"));
                String currentQuery = query.replace("#ListOfCodes", param);
                jdbcTemplate.update(currentQuery);
            }
        }
    }
}
