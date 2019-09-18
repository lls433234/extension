package com.jiuyao.boot.service.impl;

import com.jiuyao.boot.entity.ServiceResult;
import com.jiuyao.boot.utils.AliyunOSSUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;

@Service
@Slf4j
public class UploadService {
    public ServiceResult<Object> uploadFile(MultipartFile file, String fileHost) {
        ServiceResult<Object> serviceResult = new ServiceResult<>();
        log.info("文件上传");
        String suffix = AliyunOSSUtil.getSuffix(file);
        String filename = file.getOriginalFilename();
        log.info("文件上传filename =" + filename);
        try {

            if (file != null) {
                if (!"".equals(filename.trim())) {
                    File newFile = new File(filename);
                    FileOutputStream os = new FileOutputStream(newFile);
                    os.write(file.getBytes());
                    os.close();
                    file.transferTo(newFile);
                    // 上传到OSS
                    String uploadUrl = AliyunOSSUtil.upLoad(newFile, fileHost, suffix);
                    log.info("文件上传结束uploadUrl =" + uploadUrl);
                    serviceResult.setData(uploadUrl);
                    serviceResult.setMsg("成功");
                    serviceResult.setSucceed(true);
                    return serviceResult;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
