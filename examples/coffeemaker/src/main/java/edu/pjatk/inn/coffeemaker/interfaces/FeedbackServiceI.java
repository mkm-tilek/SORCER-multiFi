package edu.pjatk.inn.coffeemaker.interfaces;

import sorcer.service.Context;
import sorcer.service.ContextException;

import java.rmi.RemoteException;
public interface FeedbackServiceI {
    public Context addFeedback(Context context) throws RemoteException, ContextException;

    public Context getFeedback(Context context) throws RemoteException, ContextException;

}
