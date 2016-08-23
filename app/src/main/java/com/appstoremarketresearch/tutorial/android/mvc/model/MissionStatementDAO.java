package com.appstoremarketresearch.tutorial.android.mvc.model;

import android.content.Context;

public abstract class MissionStatementDAO
{
    protected Context mContext;
    
    protected static final String DEFAULT_REAL_MISSION_STATEMENT = 
        "Our mission is to provide the best customer service on the planet.";
    
    protected static final String DEFAULT_TEST_MISSION_STATEMENT = 
        "Our mission is to provide the best customer service on the planet, " +
        "or any other planet, and by the way, I grew up in the 1980's so yes " +
        "Pluto is still a planet!";

    public MissionStatementDAO(Context context)
    {
        mContext = context;
    }
    
    public abstract String getMissionStatement();
    
    public abstract void saveMissionStatement(String missionStatement);
}
