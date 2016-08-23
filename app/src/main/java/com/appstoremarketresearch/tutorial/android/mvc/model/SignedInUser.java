package com.appstoremarketresearch.tutorial.android.mvc.model;

import java.io.Serializable;

/**
 * Represents a user who signed into the application.
 */
public class SignedInUser implements Serializable
{
    private UserRole mUserRole;

    public UserRole getUserRole()
    {
        return mUserRole;
    }

    public void setUserRole(UserRole role)
    {
        mUserRole = role;
    }
}
