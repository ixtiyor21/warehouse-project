package com.example.lesson11.service;

import com.example.lesson11.entity.Attachment;
import com.example.lesson11.entity.AttachmentContent;
import com.example.lesson11.payload.Result;
import com.example.lesson11.repository.AttachmentContentRepository;
import com.example.lesson11.repository.AttachmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.Optional;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 22.03.2022 15:28
 * Project : lesson11
 */
@Service
public class AttachmentService {


    @Autowired
    AttachmentRepository attachmentRepository;
    @Autowired
    AttachmentContentRepository attachmentContentRepository;

    public Result uploadFile(MultipartHttpServletRequest request) throws IOException {
        Iterator<String> fileNames = request.getFileNames();
        MultipartFile file = request.getFile(fileNames.next());
        Attachment attachment = new Attachment();
        if (file != null) {
            attachment.setName(file.getOriginalFilename());
            attachment.setSize(file.getSize());
            attachment.setContentType(file.getContentType());
            Attachment saveAttachment = attachmentRepository.save(attachment);
            AttachmentContent attachmentContent=new AttachmentContent();
            attachmentContent.setBytes(file.getBytes());
            attachmentContent.setAttachment(saveAttachment);
            attachmentContentRepository.save(attachmentContent);
            return new Result("Successfully saved",true,saveAttachment.getId());
        }
        return new Result("Bad request",false);
    }

    public Result getFile(Integer id, HttpServletResponse response) throws IOException {
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(id);
        if (optionalAttachment.isEmpty()) {
            return new Result("File not found",false);
        }
        Attachment attachment = optionalAttachment.get();

        Optional<AttachmentContent> optionalAttachmentContent = attachmentContentRepository.findByAttachmentId(attachment.getId());
        if (optionalAttachmentContent.isEmpty()) {
            return new Result("File not found",false);
        }
        AttachmentContent attachmentContent = optionalAttachmentContent.get();
        response.setHeader("Content-Disposition",
                "attachment; filename=\"" + attachment.getName() + "\"");
        response.setContentType(attachment.getContentType());

        FileCopyUtils.copy(attachmentContent.getBytes(), response.getOutputStream());
        return new Result("File downloaded",true);
    }
}
