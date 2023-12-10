package com.elasri.aftas.Fish;

import com.elasri.aftas.Level.Level;
import com.elasri.aftas.Level.LevelRepository;
import com.elasri.aftas.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FishServiceImpl implements FishService {
    @Autowired
    private FishRepository fishRepository;
    @Autowired
    private LevelRepository levelRepository;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public FishRequest saveFish(FishRequest fishRequest) {
        Fish fish = modelMapper.map(fishRequest, Fish.class);
        Level level = levelRepository.findById(fishRequest.getLevel_id()).orElseThrow(()-> new ResourceNotFoundException("id level : " + fishRequest.getLevel_id()));
        fish.setLevel(level);
        Fish savedFish = fishRepository.save(fish);
        return modelMapper.map(savedFish, FishRequest.class);
    }

    @Override
    public FishRequest updateFish(FishRequest fishRequest) {
        return null;
    }

    @Override
    public void deleteFish(Long id) {
        fishRepository.deleteById(id);
    }

    @Override
    public List<FishResponse> getAllFish() {
        List<Fish> fishList = fishRepository.findAll();
        return fishList.stream().map(fish -> modelMapper.map(fish, FishResponse.class)).collect(Collectors.toList());
    }

    @Override
    public FishResponse getFish(Long id) {
        Optional<Fish> optionalFish = fishRepository.findById(id);
        return optionalFish.map(fish -> modelMapper.map(fish, FishResponse.class)).orElseThrow(()-> new ResourceNotFoundException("id fish : " + id));
    }
}
