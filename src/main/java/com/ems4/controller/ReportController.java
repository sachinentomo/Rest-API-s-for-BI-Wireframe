package com.ems4.controller;

import com.ems4.dto.EmpByDept;
import com.ems4.dto.EmpByJoin;
import com.ems4.dto.EmpByPrj;
import com.ems4.dto.Summary;
import com.ems4.service.ReportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/report")
public class ReportController {
    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }
    @GetMapping("/totalcount")
    public ResponseEntity<List<Summary>> getTotalCount () {
        List<Summary> summary = reportService.getTotalCount();
        return new ResponseEntity<>(summary, HttpStatus.OK);
    }

    @GetMapping("/empbydept")
    public ResponseEntity<List<EmpByDept>> getEmpByDept () {
        List<EmpByDept> deptSummary = reportService.getEmpByDept();
        return new ResponseEntity<>(deptSummary, HttpStatus.OK);
    }

    @GetMapping("/empbyprj")
    public ResponseEntity<List<EmpByPrj>> getEmpByPrj () {
        List<EmpByPrj> projectSummary = reportService.getEmpByPrj();
        return new ResponseEntity<>(projectSummary, HttpStatus.OK);
    }

    @GetMapping("/empbyjoin")
    public ResponseEntity<List<EmpByJoin>> getEmpByJoin () {
        List<EmpByJoin> empByJoin = reportService.getEmpByJoin();
        return new ResponseEntity<>(empByJoin, HttpStatus.OK);
    }
}
