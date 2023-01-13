package com.solvd.laba.iis.service.impl;

import com.solvd.laba.iis.domain.mark.Mark;
import com.solvd.laba.iis.domain.exception.ResourceDoesNotExistException;
import com.solvd.laba.iis.persistence.MarkRepository;
import com.solvd.laba.iis.domain.mark.MarkSearchCriteria;
import com.solvd.laba.iis.service.MarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MarkServiceImpl implements MarkService {

    private final MarkRepository markRepository;

    @Override
    public List<Mark> findAll() {
        return markRepository.findAll();
    }

    @Override
    public Mark findById(Long id) {
        return markRepository.findById(id)
                .orElseThrow(() -> new ResourceDoesNotExistException("Mark with id = " + id + " not found"));
    }

    @Override
    public List<Mark> findByCriteria(Long studentId, MarkSearchCriteria markSearchCriteria) {
        return markRepository.findByCriteria(studentId, markSearchCriteria);
    }

    @Override
    public List<Mark> findByTeacher(Long subjectId, Long teacherId) {
        return markRepository.findBySubjectAndTeacher(subjectId, teacherId);
    }

    @Override
    public Mark create(Mark mark) {
        markRepository.create(mark);
        return mark;
    }

    @Override
    public Mark save(Mark mark) {
        findById(mark.getId());
        markRepository.save(mark);
        return mark;
    }

    @Override
    public void delete(Long id) {
        markRepository.delete(id);
    }

}
