package org.iit.cc.aggregator.service;

import org.iit.cc.aggregator.model.DoctorRedShift;
import org.iit.cc.aggregator.repository.RedshiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RedShiftService {

    @Autowired
    private RedshiftRepository redshiftRepository;

    public void saveNewDoctors(List<DoctorRedShift> doctors){
        redshiftRepository.saveEntriesInBatch(doctors);
    }

}
