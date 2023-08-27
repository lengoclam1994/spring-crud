package com.crud.springcrud.controller;

import com.crud.springcrud.dto.NewDTO;
import com.crud.springcrud.dto.NewOutputDTO;
import com.crud.springcrud.service.NewService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class NewController {

    private final NewService newService;

    public NewController(NewService newService) {
        this.newService = newService;
    }

    @GetMapping(value = "/new")
    public NewOutputDTO showNew(@RequestParam(value = "page", required = false) Integer page,
                                @RequestParam(value = "limit", required = false) Integer limit) {
        NewOutputDTO result = new NewOutputDTO();
        if (page != null && limit != null) {
            result.setPage(page);
            Pageable pageable = PageRequest.of(page - 1, limit);
            result.setListResult(newService.findAll(pageable));
            result.setTotalPage((int) Math.ceil((double) (newService.totalItem()) / limit));
        } else {
            result.setListResult(newService.findAll());
        }
        return result;
    }

    @PostMapping(value = "/new")
    public NewDTO createNew(@RequestBody NewDTO model) {
        return newService.save(model);
    }

    @PutMapping(value = "/new/{id}")
    public NewDTO updateNew(@RequestBody NewDTO model, @PathVariable("id") long id) {
        model.setId(id);
        return newService.save(model);
    }

    @DeleteMapping(value = "/new")
    public void deleteNew(@RequestBody long[] ids) {
        newService.delete(ids);
    }
}
