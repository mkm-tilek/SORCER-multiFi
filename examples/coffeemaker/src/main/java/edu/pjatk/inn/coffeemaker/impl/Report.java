package edu.pjatk.inn.coffeemaker.impl;

import sorcer.core.context.ServiceContext;
import sorcer.service.Context;
import sorcer.service.ContextException;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Report {
    private long id;
    private Date date;
    private String text;

    public Report(
            long _id,
            String _text
    )
    {
        id = _id;
        text = _text;

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        date = new Date(System.currentTimeMillis());
    }

    public Report(Context _context)
    {
        try {
            id = (Long)_context.getValue("id");
            date = (Date)_context.getValue("date");
            text = (String)_context.getValue("text");
        } catch (ContextException e) {
            throw new RuntimeException(e);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public long GetId()
    {
        return id;
    }

    public String GetReportText()
    {
        return text;
    }

    public Date GetReportTime()
    {
        return date;
    }

    public Context getContext() throws ContextException {
        Context context = new ServiceContext();
        context.putValue("id", id);
        context.putValue("date", date);
        context.putValue("text", text);
        return context;
    }
}
