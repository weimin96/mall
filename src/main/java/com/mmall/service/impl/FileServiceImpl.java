package com.mmall.service.impl;

import com.google.common.collect.Lists;
import com.mmall.service.IFileService;
import com.mmall.util.FTPUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import lombok.extern.slf4j.Slf4j;


/**
 * Created by Oreo
 * on 2018/5/29
 */
@Service("IFileService")
@Slf4j
public class FileServiceImpl implements IFileService {

    public String upload(MultipartFile file, String path) {
        // 拿到上传文件的原始文件名
        String fileName = file.getOriginalFilename();
        // 获取文件扩展名
        String fileExtensionName = fileName.substring(fileName.lastIndexOf(".") + 1);
        // 上传文件名
        String uploadFileName = UUID.randomUUID().toString() + "." + fileExtensionName;
        log.info("开始上传文件，上传文件的文件名：{}，上传的路径：{}，新文件名：{}", fileName, path, uploadFileName);
        File fileDir = new File(path);
        // 若不存在此路径则创建
        if (!fileDir.exists()) {
            fileDir.setWritable(true);// 获取写权限
            fileDir.mkdirs();// mkdirs 可以创建多层级文件夹
        }
        // 新建文件
        File targetFile = new File(path, uploadFileName);
        try {
            // 写入
            file.transferTo(targetFile);
            // 将文件上传到ftp服务器
            FTPUtil.uploadFile(Lists.newArrayList(targetFile));
            // 删除upload下的文件
            targetFile.delete();
        } catch (IOException e) {
            log.error("上传文件异常");
        }
        return targetFile.getName();
    }
}
