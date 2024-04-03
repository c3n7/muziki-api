package tech.c3n7.muziki.core.service;

import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;

public interface StorageService {
    void init();

    void store(MultipartFile file);

    Path load(String fileName);
}
