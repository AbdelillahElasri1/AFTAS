package com.elasri.aftas.Fish;

import java.util.List;

public interface FishService{
    FishRequest saveFish(FishRequest fishRequest);
    FishRequest updateFish(FishRequest fishRequest);
    void deleteFish(Long id);
    List<FishResponse> getAllFish();
    FishResponse getFish(Long id);
}
