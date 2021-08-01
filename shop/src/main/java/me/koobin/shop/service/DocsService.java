package me.koobin.shop.service;


import lombok.RequiredArgsConstructor;
import me.koobin.shop.entity.Docs;
import me.koobin.shop.repository.DocsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class DocsService {

    private final DocsRepository docsRepository;

    public Docs create(Docs docs) {
        return docsRepository.save(docs);
    }


    public Docs read(Long id) {
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
