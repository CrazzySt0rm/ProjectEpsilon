package org.example.model;

import jakarta.annotation.Generated;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Epsilon")
public class Epsilon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "title")
    private String title;
    @Column(name = "name")
    private String name;
    @Column(name = "description", columnDefinition = "text")
    private  String description;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "epsilon")
    private List<Image> images = new ArrayList<>();

    private LocalDateTime dateOfCreated;

    @PrePersist
    private void init() { dateOfCreated = LocalDateTime.now(); }


    private Long PreviewImageId;

    public void addImageToEpsilon(Image image) {
        image.setEpsilon(this);
        images.add(image);
    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }


    public List<Image> getImages() { return images; }

    public void setImages(List<Image> images) { this.images = images; }

    public LocalDateTime getDateOfCreated() { return dateOfCreated; }

    public void setDateOfCreated(LocalDateTime dateOfCreated) { this.dateOfCreated = dateOfCreated; }

    public Long getPreviewImageId() { return PreviewImageId; }

    public void setPreviewImageId(Long previewImageId) { PreviewImageId = previewImageId; }
}
