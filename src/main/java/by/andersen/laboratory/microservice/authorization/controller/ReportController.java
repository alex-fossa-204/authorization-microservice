package by.andersen.laboratory.microservice.authorization.controller;

import by.andersen.laboratory.microservice.authorization.model.ReportDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
public class ReportController extends ErrorControllerHandler {

    @PostMapping("/report/add")
    public ResponseEntity<ReportDto> addReport(@RequestBody ReportDto reportDto) {
        return new ResponseEntity<>(null, OK);
    }

    @GetMapping("/report/get/all/by/user/{userUid}")
    public ResponseEntity<List<ReportDto>> getAllUserReports(@PathVariable Long userUid) {
        return new ResponseEntity<>(null, OK);
    }

    @PatchMapping("/report/update")
    public ResponseEntity<ReportDto> updateReport(@RequestBody ReportDto reportDto) {
        return new ResponseEntity<>(null, OK);
    }

    @DeleteMapping("/report/delete")
    public ResponseEntity<ReportDto> deleteReport(@RequestBody ReportDto reportDto) {
        return new ResponseEntity<>(null, OK);
    }

}
