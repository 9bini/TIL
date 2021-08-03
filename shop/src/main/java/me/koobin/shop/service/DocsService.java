package me.koobin.shop.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.koobin.shop.dto.CreateDocsDTO;
import me.koobin.shop.dto.Header;
import me.koobin.shop.dto.ReadDocsDTO;
import me.koobin.shop.dto.UpdateDocsDTO;
import me.koobin.shop.entity.Docs;
import me.koobin.shop.repository.DocsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Slf4j
@RequiredArgsConstructor
@Service @Transactional
public class DocsService {


    private final DocsRepository docsRepository;

    public Header<CreateDocsDTO> create(CreateDocsDTO createDocsDTO) {
        Docs docs = insert(createDocsDTO);
        return (docs != null)? Header.OK(createDocsDTO) : Header.Error();
    }

    private Docs insert(CreateDocsDTO createDocsDTO) {
        Docs docs = Docs.builder()
                .account(createDocsDTO.getAccount())
                .email(createDocsDTO.getEmail())
                .phoneNumber(createDocsDTO.getPhoneNumber())
                .build();
        return docsRepository.save(docs);
    }


    @Transactional(readOnly = true)
    public Header<ReadDocsDTO> read(Long id) {
        Docs docs = docsRepository.getById(id);
        ReadDocsDTO readDocsDTO = new ReadDocsDTO(docs);
        return (docs != null)? Header.OK(readDocsDTO) : Header.Error();
    }

    public Header<UpdateDocsDTO> update(UpdateDocsDTO updateDocsDTO) {
        Optional<Docs> byIdDocs = docsRepository.findById(updateDocsDTO.getId());

        Docs docs = byIdDocs.map(dbDocs -> {
                    dbDocs.update(updateDocsDTO.getAccount(), updateDocsDTO.getEmail(), updateDocsDTO.getPhoneNumber());
                    return dbDocs;
                }).map(docsRepository::save)
                .orElseThrow(IllegalArgumentException::new);
        return (docs != null)? Header.OK(updateDocsDTO) : Header.Error();
    }

    public boolean delete(Long id) {
        return docsRepository.findById(id)
                .map(docs -> {
                    docsRepository.delete(docs);
                    return true;
                }).orElse(false);
    }

}
