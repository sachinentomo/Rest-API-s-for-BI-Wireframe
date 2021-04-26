package com.ems4.service;
import com.ems4.Repository.ReportRepository;
import com.ems4.dto.EmpByDept;
import com.ems4.dto.EmpByJoin;
import com.ems4.dto.EmpByPrj;
import com.ems4.dto.Summary;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ReportService {
    private final ReportRepository reportRepository;

    public ReportService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    public List<Summary> getTotalCount(){
        return reportRepository.getTotalCount();
    }

    public List<EmpByDept> getEmpByDept(){
        return reportRepository.getEmpByDept();
    }

    public List<EmpByPrj> getEmpByPrj(){
        return reportRepository.getEmpByPrj();
    }

    public List<EmpByJoin> getEmpByJoin(){
        return reportRepository.getEmpByJoin();
    }
}
