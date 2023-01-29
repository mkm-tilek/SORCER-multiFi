package edu.pjatk.inn.coffeemaker.interfaces;

import sorcer.service.Context;
import sorcer.service.ContextException;

import java.rmi.RemoteException;
public interface FeedbackServiceI {
    public Context AddFeedback(Context context) throws RemoteException, ContextException;

    public Context GetFeedback(Context context) throws RemoteException, ContextException;

    public Context DeleteFeedback(Context context) throws RemoteException, ContextException;

    public Context GetAllFeedbacks(Context context) throws RemoteException, ContextException;
}
