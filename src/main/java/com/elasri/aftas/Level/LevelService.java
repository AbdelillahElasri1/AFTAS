package com.elasri.aftas.Level;

import java.util.List;

public interface LevelService {
    LevelRequest createLevel(LevelRequest levelRequest);
    LevelRequest updateLevel(LevelRequest levelRequest);
    List<LevelResponse> getAllLevels();
    LevelResponse getLevel(Integer code);
    void deleteLevel(Integer code);
}
