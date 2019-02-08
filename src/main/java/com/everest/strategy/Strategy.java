package com.everest.strategy;

import com.everest.bean.Kingdom;

public interface Strategy {
    Kingdom getRuler() throws Exception;
}
