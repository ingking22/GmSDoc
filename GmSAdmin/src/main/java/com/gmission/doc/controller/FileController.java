package com.gmission.doc.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

import org.apache.commons.io.FilenameUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.gmission.doc.common.CommonUtils;
import com.gmission.doc.common.Constants;
import com.gmission.doc.service.RequestExportService;
import com.gmission.doc.vo.FileUploadResultVO;
import com.gmission.doc.vo.FileUploadTestVO;
import com.gmission.doc.vo.RequestUploadFileTempVO;

@Controller
@RequestMapping("/File")
public class FileController {

    private final Logger logger = LogManager.getLogger(FileController.class);

    @Autowired
    private RequestExportService requestExportService;



    @PostMapping("/UploadExportFile")
    @ResponseBody
    public String requestExport(Model model) {

        return "SUCCESS";
    }


    @GetMapping("/FileDownLoadTest")
    public ResponseEntity<Resource> FileDownLoadTest() throws IOException {
        long beforeTime = System.currentTimeMillis();


        try {

            ResponseEntity<Resource> result = null;
            HttpHeaders httpHeaders = new HttpHeaders();
            File file = new File("F:/FAXSYSTEM_UTILITY/mu_visual_studio_2010_sp1_x86_dvd_651704.iso");
            //FileSystemResource resource = new FileSystemResource(file);

            httpHeaders.set(HttpHeaders.LAST_MODIFIED, String.valueOf(file.lastModified()));
            httpHeaders.set(HttpHeaders.CONTENT_DISPOSITION, String.format("attachment ; filename=\"%s\"", file.getName()));
            httpHeaders.set(HttpHeaders.CONTENT_LENGTH, String.valueOf(file.length()));


            /*
            final InputStream inputStream = new FileInputStream(file);

            StreamingResponseBody responseBody = outputStream -> {
                int nRead ;
                byte[] buffer = new byte[65536];

                while((nRead = inputStream.read(buffer , 0 ,buffer.length) ) != -1) {
                    outputStream.write(buffer , 0 , nRead);
                }

                inputStream.close();
            };
            */


            return ResponseEntity.ok()
                           .headers(httpHeaders)
                           .contentLength(file.length())
                           .contentType(MediaType.APPLICATION_OCTET_STREAM)
                           .body(getFileContent(file));

        } finally {

            long afterTime = System.currentTimeMillis();
            long secDiffTime = (afterTime - beforeTime)/1000;
            System.out.println("시간차이 밀리세컨드 : " + (afterTime - beforeTime));
            System.out.println("시간차이(m) : " + secDiffTime );

        }
    }


    private Resource getFileContent(File file) throws FileNotFoundException {
        return new InputStreamResource(new FileInputStream(file));
    }



    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // 파일 업로드 테스트 진행
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @PostMapping("/FileUploadTest")
    @ResponseBody
    public FileUploadResultVO FileUploadTest(@ModelAttribute FileUploadTestVO postParam,
                @RequestParam("files") MultipartFile[]  files
                                ) throws IOException {

        FileUploadResultVO resultVO = new FileUploadResultVO();

        boolean bResult[] = { false };
        try {
            System.out.println(String.format("generateID=[%s]", postParam ));

            RequestUploadFileTempVO requestUploadFileTempVO = new RequestUploadFileTempVO();

            String tempRootDir = Constants.REQUEST_EXPORT_TEMP_UPLOAD_ROOTDIR;
            if(!new File(tempRootDir).exists()) new File(tempRootDir).mkdirs();

            requestUploadFileTempVO.setTempfileid(postParam.getGenerateID());

            Arrays.asList(files).stream().forEach(a -> {
                String saveTempPath = String.format("%s%s%s",tempRootDir, File.separator, a.getOriginalFilename()) ;
                logger.info(String.format("Save File Path=%s",saveTempPath));

                saveTempPath = CommonUtils.FileNameDupCheck(saveTempPath);
                logger.info(String.format("Save File Path File Duplication Check=%s",saveTempPath));
                try {
                    a.transferTo(new File(saveTempPath) );
                    requestUploadFileTempVO.setFilepath(saveTempPath);
                    requestUploadFileTempVO.setFilename(FilenameUtils.getName(saveTempPath));
                    requestUploadFileTempVO.setFilesize( (int)new File(saveTempPath).length() );

                    requestExportService.insertRequestUploadFileTemp(requestUploadFileTempVO);

                    bResult[0] = true;
                } catch (Exception e) {
                    logger.error("Occurred Exceptoon" , e);
                    bResult[0] = false;
                }
            });


            resultVO.setResult("SUCCESS");
            resultVO.setDesc("SUCCESS");

        } catch(Exception exception) {

            resultVO.setResult("FAIL");
            resultVO.setDesc(exception.toString());

        }


        return resultVO;


    }

















}
