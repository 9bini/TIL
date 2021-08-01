package me.koobin.shop.controller.api;

import lombok.RequiredArgsConstructor;
import me.koobin.shop.dto.Header;
import me.koobin.shop.entity.Docs;
import me.koobin.shop.service.DocsService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/docs")
public class DocsApiController {
    private final DocsService docsService;

    @PostMapping("")
    public Header<Docs> create(@RequestBody Docs requestDocs) {
        Docs docs = docsService.create(requestDocs);
        return(docs != null)? Header.OK(docs) : Header.Error();
    }

    @GetMapping("{id}")
    public Header<Docs> read(@PathVariable Long id) {
        Docs docs = docsService.read(id);
        return(docs != null)? Header.OK(docs) : Header.Error();
    }

    @PutMapping("")
    public Header<Docs> update(@RequestBody Docs requestDocs) {
        Docs docs = docsService.update(requestDocs);
        return(docs != null)? Header.OK(docs) : Header.Error();
    }

    @DeleteMapping("{id}")
    public Header<Docs> delete(@PathVariable Long id) {
        boolean isDelete = docsService.delete(id);
        return(isDelete)? Header.OK() : Header.Error();
    }

}
