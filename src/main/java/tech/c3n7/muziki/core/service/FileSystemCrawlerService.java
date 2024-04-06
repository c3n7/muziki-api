package tech.c3n7.muziki.core.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

@Service
public class FileSystemCrawlerService {
    public List<String> getMusicFiles() {
        // https://mkyong.com/java/how-to-find-files-with-certain-extension-only/
        try (Stream<Path> stream = Files.walk(Paths.get("/home/c3n7/external/Backups/330/Linux/Music"))) {
            return stream
                    .map(p -> p.toString().toLowerCase())
                    .filter(file -> file.endsWith("mp3"))
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
