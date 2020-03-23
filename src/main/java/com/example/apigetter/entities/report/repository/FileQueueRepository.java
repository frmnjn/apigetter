package com.example.apigetter.entities.report.repository;

import com.example.apigetter.entities.report.model.FILE_QUEUE;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FileQueueRepository extends MongoRepository<FILE_QUEUE, String> {
    //Page<FILE_QUEUE> findByFileIdIgnoreCaseContainsAndFilenameInputIgnoreCaseContainsAndRegionalIn(String fileId, String filenameInput, List<String> regional, Pageable pageable);
    //List<FILE_QUEUE> findByFileIdByOrderByFilenameInputDesc(String fileId);
    List<FILE_QUEUE> findByFileId(String fileId);

    Page<FILE_QUEUE> findByFileIdIgnoreCaseContainsAndFilenameInputIgnoreCaseContainsAndRegionalInAndWorkerIgnoreCaseContainsAndStepIgnoreCaseContainsAndStatusIgnoreCaseContains(String fileId, String filenameInput, List<String> regional, String worker, String step, String status, Pageable pageable);

    Page<FILE_QUEUE> findByFileIdIgnoreCaseContainsAndFilenameInputIgnoreCaseContainsOrRegionalInAndWorkerIgnoreCaseContainsAndStepIgnoreCaseContainsAndStatusIgnoreCaseContains(String fileId, String filenameInput, List<String> regional, String worker, String step, String status, Pageable pageable);

    Page<FILE_QUEUE> findByFileIdInAndFilenameInputIgnoreCaseContainsAndRegionalInAndWorkerIgnoreCaseContainsAndStepIgnoreCaseContainsAndStatusIgnoreCaseContains(List<String> fileId, String filenameInput, List<String> regional, String worker, String step, String status, Pageable pageable);

    Page<FILE_QUEUE> findByFileIdIgnoreCaseContainsAndFilenameInputIgnoreCaseContainsAndRegionalInAndStatus(String fileId, String filenameInput, List<String> regional, String status, Pageable pageable);

    Page<FILE_QUEUE> findByFileIdInAndFilenameInputIgnoreCaseContainsAndStatus(List<String> fileId, String filenameInput, String status, Pageable pageable);

    Page<FILE_QUEUE> findByStatus(String status, Pageable pageable);

    List<FILE_QUEUE> findByStatusIn(List<String> status);

    List<FILE_QUEUE> findByStatusCpNotIn(List<Integer> statusCp, Pageable pageable);

    List<FILE_QUEUE> findByStatusAndStatusCpNotIn(String status, List<Integer> statusCp, Pageable pageable);

    Page<FILE_QUEUE> findByStatusAndWorker(String status, String worker, Pageable pageable);

    List<FILE_QUEUE> findByStatusIgnoreCaseAndWorker(String status, String worker);

    FILE_QUEUE findByFilenameInput(String filenameInput);

    FILE_QUEUE findByChecksum(String checksum);

    FILE_QUEUE findByChecksumAndFilenameInputAndFileId(String checksum, String filenameInput, String fileId);

    FILE_QUEUE findByFilenameInputAndFileId(String filenameInput, String fileId);

    long countByStatusAndRegionalIn(String status, List<String> regional);

    List<FILE_QUEUE> findByStatusAndRegionalIn(String status, List<String> regional);

    Page<FILE_QUEUE> findByStatusAndSyncHadoop(String status, String syncHadoop, Pageable pageable);

    List<FILE_QUEUE> findByRegionalIn(List<String> regional);

    List<FILE_QUEUE> findByStatusIgnoreCase(String status);
}
