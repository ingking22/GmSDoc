package com.gmission.doc.common;

import java.io.File;

import org.apache.commons.io.FilenameUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class CommonUtils {

    private final static Logger logger = LogManager.getLogger(CommonUtils.class);

    public static String FileNameDupCheck(String fullPath) {

        if(new File(fullPath).exists()) {
            String reNamePath = "";

            String fileDir = FilenameUtils.getFullPath(fullPath);
            String fileName = FilenameUtils.getName(fullPath);
            String fileExtension = FilenameUtils.getExtension(fullPath);
            fileName = fileName.replace(String.format(".%s", fileExtension), "");
            String combinePath = "";

            int fileIdx = 1;
            while(true) {
                combinePath = String.format("%s%s(%d).%s", fileDir, fileName ,fileIdx, fileExtension );
                logger.info(String.format("Combine Path=[%s]", combinePath));

                if(new File(combinePath).exists() )
                    fileIdx++;
                else {
                    reNamePath = combinePath;
                    break;
                }
            }
            return reNamePath;
        }
        else
            return fullPath;

    }

}
