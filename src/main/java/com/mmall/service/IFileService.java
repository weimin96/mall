package com.mmall.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Oreo
 * on 2018/5/29
 */
public interface IFileService {
    String upload(MultipartFile file, String path);
}
