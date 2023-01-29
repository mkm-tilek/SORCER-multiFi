package edu.pjatk.inn.coffeemaker.impl;

import sorcer.core.context.ServiceContext;
import sorcer.service.Context;
import sorcer.service.ContextException;

import java.rmi.RemoteException;

public class User {
    private Long id;
    private String userName;
    private String phoneNumber;
    private String email;
    private String password;
    private String authKey;
    private Long rights = 0L;
    public User(
            Long _id,
            String _userName,
            String _phoneNumber,
            String _email,
            String _password
    )
    {
        id = _id;
        userName = _userName;
        phoneNumber = _phoneNumber;
        email = _email;
        password = _password;

        authKey = _id.toString();
    }

    public User(Context _context)
    {
        try {
            id = (Long)_context.getValue("id");
            userName = (String)_context.getValue("userName");
            email = (String)_context.getValue("email");
            password = (String)_context.getValue("password");
            phoneNumber = (String)_context.getValue("phoneNumber");
        } catch (ContextException e) {
            throw new RuntimeException(e);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }

        authKey = id.toString();
    }

    public  Long GetUserId()
    {
        return id;
    }

    public  String GetUserName()
    {
        return userName;
    }

    public boolean SetUserName(String _userName)
    {
        userName = _userName;
        return true;
    }

    public String GetEmail()
    {
        return email;
    }

    public boolean SetEmail(String _email)
    {
        email = _email;
        return true;
    }

    public String GetPhoneNumber()
    {
        return phoneNumber;
    }

    public boolean SetPhoneNumber(String _phoneNumber)
    {
        phoneNumber = _phoneNumber;
        return true;
    }
    public  String GetAuthKey()
    {
        return authKey;
    }
    public String GetPassword()
    {
        return password;
    }
    public boolean UpdatePassword(String _password)
    {
        password = _password;
        return true;
    }
    public Long GetRights()
    {
        return rights;
    }

    public Context getContext() throws ContextException {
        Context context = new ServiceContext();
        context.putValue("id", id);
        context.putValue("userName", userName);
        context.putValue("phoneNumber", phoneNumber);
        context.putValue("email", email);
        context.putValue("password", password);
        return context;
    }
}
