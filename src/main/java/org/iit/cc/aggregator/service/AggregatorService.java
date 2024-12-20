package org.iit.cc.aggregator.service;

import org.iit.cc.aggregator.model.Doctor;
import org.iit.cc.aggregator.model.DoctorRedShift;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AggregatorService {
    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    private RedShiftService redShiftService;

    public void fetchAndSaveDoctors() {
        List<Doctor> doctors = webClientBuilder.build()
                .get()
                .uri("http://doctor-service/api/doctors/all")
                .retrieve()
                .bodyToFlux(Doctor.class) // Reactive stream for a list of doctors
                .collectList() // Convert Flux to Mono<List<Doctor>>
                .block(); // Block to get the final list (blocking call, not recommended in reactive flow)

        saveDoctors(doctors);
    }

    public void saveDoctors(List<Doctor> doctors) {
        LocalDate today = LocalDate.now();

        System.out.println(doctors.stream().filter(doctor -> doctor.getReg_date().toLocalDate().equals(today)).count());
        redShiftService.saveNewDoctors(doctors.stream()
                .filter(doctor -> doctor.getReg_date().toLocalDate().equals(today))
                .map(doctor -> new DoctorRedShift(
                        Integer.parseInt(doctor.getId().substring(1)),
                        doctor.getName(),
                        doctor.getSpecialization()
                ))
                .collect(Collectors.toList()));

    }
}
