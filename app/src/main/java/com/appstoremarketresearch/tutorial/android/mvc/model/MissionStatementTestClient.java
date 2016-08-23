package com.appstoremarketresearch.tutorial.android.mvc.model;

import android.content.Context;
import android.content.SharedPreferences;

public class MissionStatementTestClient extends MissionStatementDAO
{
    private String MISSION_STATEMENT_KEY = "MISSION_STATEMENT";
    private String SHARED_PREFS_FILE_NAME = MissionStatementTestClient.class.getSimpleName();
    
    public MissionStatementTestClient(Context context)
    {
        super(context);
    }
    
    @Override
    public String getMissionStatement()
    {
        SharedPreferences prefs = mContext.getSharedPreferences(SHARED_PREFS_FILE_NAME, Context.MODE_PRIVATE);        
        return prefs.getString(MISSION_STATEMENT_KEY, DEFAULT_TEST_MISSION_STATEMENT);
    }
    
    @Override
    public void saveMissionStatement(String missionStatement)
    {
        SharedPreferences prefs = mContext.getSharedPreferences(SHARED_PREFS_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(MISSION_STATEMENT_KEY, missionStatement);        
        editor.apply();
    }
}
