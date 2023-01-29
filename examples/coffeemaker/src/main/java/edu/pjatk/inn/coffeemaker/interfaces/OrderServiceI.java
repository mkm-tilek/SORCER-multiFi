package edu.pjatk.inn.coffeemaker.interfaces;

import sorcer.service.Context;
import sorcer.service.ContextException;

import java.rmi.RemoteException;
public interface OrderServiceI {
    public Context MakeOrder(Context context) throws RemoteException, ContextException;

    public Context GetOrder(Context context) throws RemoteException, ContextException;

    public Context DeleteOrder(Context context) throws RemoteException, ContextException;

    public Context EditOrder(Context context) throws RemoteException, ContextException;

    public Context AddRecipeToOrder(Context context) throws RemoteException, ContextException;

    public Context AddPredefinedRecipeToOrder(Context context) throws RemoteException, ContextException;

    public Context DeleteRecipeFromOrder(Context context) throws RemoteException, ContextException;

    public Context GetAllOrders(Context context) throws RemoteException, ContextException;
}
