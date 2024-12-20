package org.iit.cc.aggregator.repository;

import org.iit.cc.aggregator.model.DoctorRedShift;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RedshiftRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void saveEntriesInBatch(List<DoctorRedShift> doctors) {
        String sql = "INSERT INTO doctor_dim ( name, specialization) VALUES (?, ?)";

        jdbcTemplate.batchUpdate(sql, doctors, 100, (ps, argument) -> {
           ps.setString(1, argument.getName());
           ps.setString(2, argument.getSpecialization());
        });
    }
}
