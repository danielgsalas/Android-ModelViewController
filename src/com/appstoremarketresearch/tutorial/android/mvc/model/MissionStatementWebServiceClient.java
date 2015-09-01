package com.appstoremarketresearch.tutorial.android.mvc.model;

import android.content.Context;
import android.content.SharedPreferences;

public class MissionStatementWebServiceClient extends MissionStatementDAO
{
    private String MISSION_STATEMENT_KEY = "MISSION_STATEMENT";
    private String SHARED_PREFS_FILE_NAME = MissionStatementWebServiceClient.class.getSimpleName();
    
    public MissionStatementWebServiceClient(Context context)
    {
        super(context);
    }
    
    @Override
    public String getMissionStatement()
    {
        // FUTURE IMPLEMENTATION: connect to web service
        SharedPreferences prefs = mContext.getSharedPreferences(SHARED_PREFS_FILE_NAME, Context.MODE_PRIVATE);
        return prefs.getString(MISSION_STATEMENT_KEY, DEFAULT_REAL_MISSION_STATEMENT);
    }
    
    @Override
    public void saveMissionStatement(String missionStatement)
    {
        // FUTURE IMPLEMENTATION: connect to web service
        SharedPreferences prefs = mContext.getSharedPreferences(SHARED_PREFS_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(MISSION_STATEMENT_KEY, missionStatement);        
        editor.apply();
    }
}
