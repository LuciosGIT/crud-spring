package com.joselucio.crud_spring.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

@Entity
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @NotNull
    @Length(min = 5, max = 100)
    @Column(length = 100, nullable = false)
    private String name;

    @NotBlank
    @NotNull
    @Length(min = 10, max = 11)
    @Column(length =11, nullable = false)
    private String youtubeUrl;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "course_id", nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Course course;

    public Lesson(Course course, Long id, String name, String youtubeUrl) {
        this.course = course;
        this.id = id;
        this.name = name;
        this.youtubeUrl = youtubeUrl;
    }

    public Lesson() {
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYoutubeUrl() {
        return youtubeUrl;
    }

    public void setYoutubeUrl(String youtubeUrl) {
        this.youtubeUrl = youtubeUrl;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "course=" + course +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", youtubeUrl='" + youtubeUrl + '\'' +
                '}';
    }
}
