package com.elasri.aftas.Level;

import com.elasri.aftas.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LevelServiceImpl implements LevelService{
    @Autowired
    private LevelRepository levelRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public LevelRequest createLevel(LevelRequest levelRequest) {
        Level level = modelMapper.map(levelRequest, Level.class);
        Level savedLevel = levelRepository.save(level);
        return modelMapper.map(savedLevel, LevelRequest.class);
    }

    @Override
    public LevelRequest updateLevel(LevelRequest levelRequest) {
        return null;
    }

    @Override
    public List<LevelResponse> getAllLevels() {
        List<Level> levelList = levelRepository.findAll();
        return levelList.stream().map(level -> modelMapper.map(level, LevelResponse.class)).collect(Collectors.toList());
    }

    @Override
    public LevelResponse getLevel(Integer code) {
        Optional<Level> optionalLevel = levelRepository.findById(code);
        return optionalLevel.map(level -> modelMapper.map(level,LevelResponse.class)).orElseThrow(()-> new ResourceNotFoundException("level code : " + code));
    }

    @Override
    public void deleteLevel(Integer code) {
        levelRepository.deleteById(code);
    }
}
