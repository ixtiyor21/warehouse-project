package com.example.lesson11.controller;

import com.example.lesson11.payload.Result;
import com.example.lesson11.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 22.03.2022 15:24
 * Project : lesson11
 */
@RestController
@RequestMapping("/attachment")
public class AttachmentController {

    @Autowired
    AttachmentService attachmentService;

    @PostMapping("/upload")
    public Result upload(MultipartHttpServletRequest request) throws IOException {
        Result result = attachmentService.uploadFile(request);
        return result;
    }

    @GetMapping("/getFile/{id}")
    public Result getFile(@PathVariable Integer id,HttpServletResponse response) throws IOException {
        return attachmentService.getFile(id,response);
    }

}
