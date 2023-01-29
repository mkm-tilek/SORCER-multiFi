package edu.pjatk.inn.coffeemaker.impl;

import sorcer.core.context.ServiceContext;
import sorcer.service.Context;
import sorcer.service.ContextException;

import java.rmi.RemoteException;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Vector;

public class Order {
    private Long id;
    private Long userId;
    private Vector<Recipe> listOfRecipes;
    public Order(Long _id, Long _userId, Vector<Recipe> _listOfRecipes) {
        id = _id;
        userId = _userId;
        listOfRecipes = _listOfRecipes;
    }
    public Order(Context _context) {
        try {
            id = (Long) _context.getValue("id");
            userId = (Long)_context.getValue("userId");
            listOfRecipes = (Vector<Recipe>)_context.getValue("listOfRecipes");
        } catch (ContextException e) {
            throw new RuntimeException(e);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }
    public Long GetId()
    {
        return id;
    }
    public Long GetUserId()
    {
        return userId;
    }
    public List<Recipe> GetListOfRecipes()
    {
        return listOfRecipes;
    }
    public void SetListOfRecipes(Vector<Recipe> _listOfRecipes)
    {
        listOfRecipes = _listOfRecipes;
    }
    public Context getContext() throws ContextException {
        Context context = new ServiceContext();
        context.putValue("id", id);
        context.putValue("userId", userId);
        context.putValue("listOfRecipes", listOfRecipes);
        return context;
    }
}
