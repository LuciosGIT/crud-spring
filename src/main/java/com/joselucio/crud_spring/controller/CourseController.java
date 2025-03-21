package com.joselucio.crud_spring.controller;

import com.joselucio.crud_spring.dto.CourseDTO;
import com.joselucio.crud_spring.dto.CoursePageDTO;
import com.joselucio.crud_spring.service.CourseService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public CoursePageDTO list(@RequestParam(defaultValue = "0") @PositiveOrZero int page,
                              @RequestParam(defaultValue = "10") @Positive @Max(100) int pageSize) {

        return courseService.list(page, pageSize);

    }

    @GetMapping("/{id}")
    public CourseDTO findById(@PathVariable @NotNull @Positive Long id)  {

    return courseService.findById(id);

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CourseDTO create(@Valid @RequestBody CourseDTO course)  {

        return courseService.create(course);

    }

    @PutMapping("/{id}")
    public CourseDTO update(@PathVariable @NotNull @Positive Long id, @RequestBody @Valid @NotNull CourseDTO course) {

        return courseService.update(id, course);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @NotNull @Positive Long id) {

        courseService.delete(id);

    }


}
