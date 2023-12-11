package com.elasri.aftas.Hunting;

import java.util.List;

public interface HuntingService {
    HuntingRequest createHunting(HuntingRequest huntingRequest);
    HuntingRequest updateHunting(HuntingRequest huntingRequest);
    List<HuntingResponse> getAllHunting();
    HuntingResponse getHunting(Long id);
    void deleteHunting(Long id);
}
