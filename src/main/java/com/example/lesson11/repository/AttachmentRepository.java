package com.example.lesson11.repository;

import com.example.lesson11.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 22.03.2022 15:31
 * Project : lesson11
 */
@Repository
public interface AttachmentRepository extends JpaRepository<Attachment,Integer> {
}
