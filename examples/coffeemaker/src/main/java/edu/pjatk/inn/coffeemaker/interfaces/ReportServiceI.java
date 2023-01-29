package edu.pjatk.inn.coffeemaker.interfaces;

import sorcer.service.Context;
import sorcer.service.ContextException;

import java.rmi.RemoteException;
public interface ReportServiceI {
    public Context GenerateReport(Context context) throws RemoteException, ContextException;
    public Context GetReportById(Context context) throws RemoteException, ContextException;
    public Context GetLastReport(Context context) throws RemoteException, ContextException;
    public Context DeleteReport(Context context) throws RemoteException, ContextException;
    public Context GetAllReports(Context context) throws RemoteException, ContextException;

}
