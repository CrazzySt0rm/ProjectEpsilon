package org.example.services;

import lombok.extern.slf4j.Slf4j;
import org.example.model.Epsilon;
import org.example.model.Image;
import org.example.repository.EpsilonRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

@Service
@Slf4j
public class EpsilonService {

    public final EpsilonRepository epsilonRepository;

    public EpsilonService(EpsilonRepository epsilonRepository) {
        this.epsilonRepository = epsilonRepository;
    }

    public List<Epsilon> epsilonList(String title) {
        if (title != null) return epsilonRepository.findByTitle(title);
        return epsilonRepository.findAll();
    }

    private static Logger log = Logger.getLogger(Epsilon.class.getName());

    private Image toImageEntity(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());
        return image;
    }

    public void saveEpsilon(Epsilon epsilon, MultipartFile file1) throws IOException {
        Image image1;
        if (file1.getSize() != 0) {
            image1 = toImageEntity(file1);
            image1.setPreviewImage(true);
            epsilon.addImageToEpsilon(image1);
        }
        log.info(epsilon.getTitle());
        Epsilon epsilonFromDb = epsilonRepository.save(epsilon);
        epsilonFromDb.setPreviewImageId(epsilonFromDb.getImages().get(0).getId());
        epsilonRepository.save(epsilon);
    }

    public void deleteEpsilon(Long id) {
        epsilonRepository.deleteById(id);
    }

    public Epsilon getEpsilonById(Long id) {
        return epsilonRepository.findById(id).orElse(null);
    }
}


