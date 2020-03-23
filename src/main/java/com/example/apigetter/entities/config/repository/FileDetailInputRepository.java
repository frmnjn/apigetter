package com.example.apigetter.entities.config.repository;

import com.example.apigetter.entities.config.model.FILE_DETAIL_INPUT;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileDetailInputRepository extends MongoRepository<FILE_DETAIL_INPUT, String> {
    Page<FILE_DETAIL_INPUT> findByFileIdIgnoreCaseContainsAndFileIdNameIgnoreCaseContainsAndRegionalIn(String fileId, String fileIdName, List<String> regional, Pageable pageable);

    Page<FILE_DETAIL_INPUT> findByFileIdInAndFileIdNameIgnoreCaseContainsOrRegionalIn(List<String> fileId, String fileIdName, List<String> regional, Pageable pageable);

    List<FILE_DETAIL_INPUT> findByRegionalIn(List<String> regional);

    List<FILE_DETAIL_INPUT> findByFileIdInOrRegionalIn(List<String> fileid, List<String> regional);

    List<FILE_DETAIL_INPUT> findByFileIdIgnoreCaseContains(String fileId);

    FILE_DETAIL_INPUT findByFileId(String fileId);

    List<FILE_DETAIL_INPUT> findByActive(boolean active);
}
