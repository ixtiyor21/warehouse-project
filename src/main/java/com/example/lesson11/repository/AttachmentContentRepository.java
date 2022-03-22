package com.example.lesson11.repository;

import com.example.lesson11.entity.AttachmentContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 22.03.2022 15:34
 * Project : lesson11
 */
@Repository
public interface AttachmentContentRepository extends JpaRepository<AttachmentContent,Integer> {
    Optional<AttachmentContent> findByAttachmentId(Integer id);
}
