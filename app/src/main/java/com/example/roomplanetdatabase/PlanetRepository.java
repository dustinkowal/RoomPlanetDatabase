package com.example.roomplanetdatabase;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class PlanetRepository {

    private PlanetDAO mPlanetDao;
    private LiveData<List<Planet>> mAllPlanets;

    PlanetRepository(Application application) {
        PlanetRoomDatabase db = PlanetRoomDatabase.getDatabase(application);
        mPlanetDao = db.planetDAO();
        mAllPlanets = mPlanetDao.getAllPlanets();
    }

    LiveData<List<Planet>> getAllWords() {
        return mAllPlanets;
    }

    public void insert (Planet planet) {
        new insertAsyncTask(mPlanetDao).execute(planet);
    }

    private static class insertAsyncTask extends AsyncTask<Planet, Void, Void> {

        private PlanetDAO mAsyncTaskDao;

        insertAsyncTask(PlanetDAO dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Planet... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
