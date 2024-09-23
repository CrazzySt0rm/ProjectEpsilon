package org.example.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "image_one")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "originalFileName")
    private String originalFileName;
    @Column(name = "name")
    private String name;
    @Column(name = "size")
    private long size;
    @Column(name = "contentType")
    private String contentType;
    @Column(name = "isPreviewImage")
    private boolean isPreviewImage;
    @Lob
    private byte[] bytes;


    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private Epsilon epsilon;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOriginalFileName() {
        return originalFileName;
    }

    public void setOriginalFileName(String originalFileName) {
        this.originalFileName = originalFileName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public boolean isPreviewImage() {
        return isPreviewImage;
    }

    public void setPreviewImage(boolean previewImage) {
        isPreviewImage = previewImage;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public Epsilon getEpsilon() { return epsilon; }

    public void setEpsilon(Epsilon epsilon) { this.epsilon = epsilon; }
}
