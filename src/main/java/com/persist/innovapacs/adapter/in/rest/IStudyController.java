package com.persist.innovapacs.adapter.in.rest;

import com.persist.innovapacs.adapter.in.rest.model.PageRestModel;
import com.persist.innovapacs.adapter.in.rest.model.StudyRestModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface IStudyController {
    @GetMapping()
    PageRestModel<StudyRestModel> findAll(@RequestParam(name = "size") Integer size, @RequestParam(name = "page") Integer page);
    @PostMapping
    StudyRestModel create(@RequestBody StudyRestModel studyRestModel);
    @PatchMapping("/{studyId}")
    StudyRestModel update(@PathVariable() String studyId, @RequestBody StudyRestModel studyRestModel);
}
