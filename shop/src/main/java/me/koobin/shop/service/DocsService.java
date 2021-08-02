package me.koobin.shop.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.koobin.shop.entity.Docs;
import me.koobin.shop.repository.DocsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Slf4j
@RequiredArgsConstructor
@Service
public class DocsService {


    private final DocsRepository docsRepository;

    public Docs create(Docs docs) {
        return docsRepository.save(docs);
    }


    public Docs read(Long id) {
        log.info("test");
        return docsRepository.getById(id);
    }

    public Docs update(Docs requestDocs) {
        Optional<Docs> byIdDocs = docsRepository.findById(requestDocs.getId());

        return byIdDocs.map(dbDocs -> {
            dbDocs.update(requestDocs.getAccount(), requestDocs.getEmail(), requestDocs.getPhoneNumber());
            return dbDocs;
        }).map(docsRepository::save)
                .orElseThrow(IllegalArgumentException::new);
    }

    public boolean delete(Long id) {
        return docsRepository.findById(id)
                .map(docs -> {
                    docsRepository.delete(docs);
                    return true;
                }).orElse(false);
    }

}
