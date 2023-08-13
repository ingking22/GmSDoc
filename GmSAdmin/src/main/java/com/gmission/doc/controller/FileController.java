package com.gmission.doc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/File")
public class FileController {

    @PostMapping("/UploadExportFile")
    @ResponseBody
    public String requestExport(Model model) {

        return "SUCCESS";
    }


}
