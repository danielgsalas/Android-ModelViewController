package com.appstoremarketresearch.tutorial.android.mvc.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.appstoremarketresearch.tutorial.android.mvc.R;
import com.appstoremarketresearch.tutorial.android.mvc.model.SignedInUser;
import com.appstoremarketresearch.tutorial.android.mvc.model.UserRole;

public class SignInActivity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
    }

    /**
     * signInEditor
     */
    public void signInEditor(View view)
    {
        signIn(UserRole.EDITOR);
    }

    /**
     * signInReader
     */
    public void signInReader(View view)
    {
        signIn(UserRole.READER);
    }

    /**
     * signInTestEditor
     */
    public void signInTestEditor(View view)
    {
        signIn(UserRole.TEST_EDITOR);
    }
    
    /**
     * signInTestReader
     */
    public void signInTestReader(View view)
    {
        signIn(UserRole.TEST_READER);
    }    

    /**
     * signIn
     */
    private void signIn(UserRole role)
    {
        SignedInUser user = new SignedInUser();
        user.setUserRole(role);

        Intent intent = new Intent(this, MissionStatementActivity.class);
        String key = SignedInUser.class.getSimpleName();
        intent.putExtra(key, user);
        startActivity(intent);
    }
}
