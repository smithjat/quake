package springboot_mongodb.controller;

import com.sun.webkit.Timer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springboot_mongodb.dao.FastScanRepository;
import springboot_mongodb.entity.FastScan;
import springboot_mongodb.entity.Student;

import javax.annotation.Resource;
import java.util.Calendar;

@Controller
@RequestMapping("/fastscan")
public class FastScanController {
    @Autowired
    private final FastScanRepository fastScanRepository;

    public FastScanController(FastScanRepository fastScanRepository) {
        this.fastScanRepository = fastScanRepository;
    }

    @ResponseBody
    @RequestMapping("/add")
    public String addFastScan(){
        FastScan fastScan = new FastScan();
        fastScan.setName("test");
        fastScan.setStatus("1");
        fastScan.setTime(Calendar.getInstance().getTimeInMillis());
        fastScanRepository.save(fastScan);
        return "SUCCEED";
    }

    @ResponseBody
    @GetMapping("/get")
    public FastScan getFastScanByname(){
        return fastScanRepository.getByName("test");
    }

}
