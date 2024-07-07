package com.mfac.controller.admin;

import com.mfac.pojo.Result;
import com.mfac.properties.AliOssProperties;
import com.mfac.util.AliOssUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/admin/file")
public class FileController {

    @Resource
    private AliOssProperties aliOssProperties;

    /**
     * 图像上传
     * @param file
     * @return
     * @throws IOException
     */
    @PostMapping("/image")
    public Result image(MultipartFile file) throws IOException {
        //传阿里云
        String originalName = file.getOriginalFilename();
        String extension = originalName.substring(originalName.lastIndexOf("."));
        String uploadName = UUID.randomUUID().toString()+extension;
        String filePath = AliOssUtil.upload(file.getBytes(), uploadName,
                aliOssProperties.getBucketName(),
                aliOssProperties.getEndpoint(), aliOssProperties.getAccessKeyId(), aliOssProperties.getAccessKeySecret());
        return Result.success(filePath);
    }
}

