package edu.pjatk.inn.coffeemaker.interfaces;

import sorcer.service.Context;
import sorcer.service.ContextException;

import java.rmi.RemoteException;
public interface DrinkerServiceI {

    public Context RegisterUser(Context context) throws RemoteException, ContextException;

    public Context GetUserKey(Context context) throws RemoteException, ContextException;

    public Context GetUserInformation(Context context) throws RemoteException, ContextException;

    public Context ChangeUserAccountStatus(Context context) throws RemoteException, ContextException;

    public Context UpdateUserPhoneNumber(Context context) throws RemoteException, ContextException;

    public Context UpdateUserEmail(Context context) throws RemoteException, ContextException;

    public Context UpdateUserPassword(Context context) throws RemoteException, ContextException;

}
