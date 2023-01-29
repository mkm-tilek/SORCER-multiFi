package edu.pjatk.inn.coffeemaker.impl;

import edu.pjatk.inn.coffeemaker.interfaces.FeedbackServiceI;
import sorcer.core.context.ServiceContext;
import sorcer.service.Context;
import sorcer.service.ContextException;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Feedback implements FeedbackServiceI {
    private Long id;
    private Long userId;
    private String text;
    private Date date;

    public Feedback(Long _id, Long _userId, String _text) {
        id = _id;
        userId = _userId;
        text = _text;

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        date = new Date(System.currentTimeMillis());
    }

    public Feedback(Context _context) {
        try {
            id = (Long) _context.getValue("id");
            userId = (Long)_context.getValue("userId");
            text = (String) _context.getValue("text");
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

    public boolean addFeedback() {
        return true;
    }

    public Date GetFeedbackTime()
    {
        return date;
    }

    public Context getContext() throws ContextException {
        Context context = new ServiceContext();
        context.putValue("id", id);
        context.putValue("userId", userId);
        context.putValue("text", text);
        return context;
    }

    @Override
    public Context addFeedback(Context context) throws RemoteException, ContextException {
        Feedback feedback = new Feedback(context);
        boolean isAdded = addFeedback();
        context.putValue("feedback/added", isAdded);
        return context;
    }

    @Override
    public Context getFeedback(Context context) throws RemoteException, ContextException {
        Feedback feedback = new Feedback(context);
        context.putValue("feedback/val", feedback.text);
        return context;
    }

}
