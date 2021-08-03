package me.koobin.shop.controller;

import lombok.RequiredArgsConstructor;
import me.koobin.shop.dto.CreateDocsDTO;
import me.koobin.shop.dto.Header;
import me.koobin.shop.dto.ReadDocsDTO;
import me.koobin.shop.dto.UpdateDocsDTO;
import me.koobin.shop.entity.Docs;
import me.koobin.shop.service.DocsService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/docs")
public class DocsApiController {

    private final DocsService docsService;

    @PostMapping("")
    public Header<CreateDocsDTO> create(@RequestBody CreateDocsDTO createDocsDTO) {
        return docsService.create(createDocsDTO);
    }

    @GetMapping("/{id}")
    public Header<ReadDocsDTO> read(@PathVariable("id") Long id) {
        return docsService.read(id);
    }

    @PutMapping("")
    public Header<UpdateDocsDTO> update(@RequestBody UpdateDocsDTO updateDocsDTO) {
        return docsService.update(updateDocsDTO);

    }

    @DeleteMapping("/{id}")
    public Header delete(@PathVariable("id") Long id) {
        boolean isDelete = docsService.delete(id);
        return(isDelete)? Header.OK() : Header.Error();
    }

}
