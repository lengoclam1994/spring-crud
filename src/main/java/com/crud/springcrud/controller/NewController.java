package com.crud.springcrud.controller;

import com.crud.springcrud.dto.NewDTO;
import com.crud.springcrud.dto.NewOutputDTO;
import com.crud.springcrud.service.NewService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/new")
public class NewController {

    private final NewService newService;

    public NewController(NewService newService) {
        this.newService = newService;
    }

    @GetMapping
    public NewOutputDTO showNew(@RequestParam(value = "page", required = false) Integer page,
                                @RequestParam(value = "limit", required = false) Integer limit) {
        NewOutputDTO result = new NewOutputDTO();
        if (page != null && limit != null) {
            result.setPage(page);
            Pageable pageable = PageRequest.of(page - 1, limit);
            Page<NewDTO> pageData = newService.findAll(pageable);
            result.setListResult(pageData.getContent());
            result.setTotalPage(pageData.getTotalPages());
        } else {
            result.setListResult(newService.findAll());
        }
        return result;
    }

    @PostMapping
    public NewDTO createNew(@RequestBody NewDTO model) {
        return newService.save(model);
    }

    @PutMapping(value = "/{id}")
    public NewDTO updateNew(@RequestBody NewDTO model, @PathVariable("id") long id) {
        model.setId(id);
        return newService.save(model);
    }

    @DeleteMapping
    public void deleteNew(@RequestBody long[] ids) {
        newService.delete(ids);
    }
}
