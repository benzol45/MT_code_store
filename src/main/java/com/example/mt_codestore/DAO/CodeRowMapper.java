package com.example.mt_codestore.DAO;

import com.example.mt_codestore.entity.Code;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CodeRowMapper implements RowMapper<Code> {
    @Override
    public Code mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Code(
                rs.getLong("id"),
                rs.getString("mark_code"),
                rs.getString("product_GTIN"),
                rs.getLong("order_id"),
                rs.getString("order_uuid"),
                rs.getBoolean("sent_for_print"),
                rs.getBoolean("sent_for_apply"),
                rs.getBoolean("applied"),
                rs.getBoolean("sale"));
    }
}
