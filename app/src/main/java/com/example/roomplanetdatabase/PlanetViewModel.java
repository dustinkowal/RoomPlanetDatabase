package com.example.roomplanetdatabase;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class PlanetViewModel extends AndroidViewModel {

    private PlanetRepository mRepository;
    private LiveData<List<Planet>> mAllPlanets;

    public PlanetViewModel(@NonNull Application application) {
        super(application);
        mRepository = new PlanetRepository(application);
        mAllPlanets = mRepository.getAllWords();
    }

    LiveData<List<Planet>> getAllPlanets() { return mAllPlanets; }

    public void insert(Planet planet) { mRepository.insert(planet); }
}
