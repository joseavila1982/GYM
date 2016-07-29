package com.networker.dao.util;


import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.context.ManagedSessionContext;
/**
 *
 * @author JOSE
 */
public abstract class ManagedSession {

    /**
     * Create a new Session.
     *
     * For this method to work, the application managed session strategy has to
     * be enabled. This basically means that the life of a session is controlled
     * by you and and not by Hibernate.
     *
     * To enable the application managed session strategy set the property
     * hibernate.current_session_context_class to "managed".
     *
     * Within this method we create a new session and set the flush mode to
     * MANUAL. This ensures that we have full control over when the session is
     * flushed to the database.
     */
    protected org.hibernate.Session createNewSession() {
        org.hibernate.classic.Session session = HibernateUtil.getSessionFactory().openSession();
        session.setFlushMode(FlushMode.MANUAL);
        ManagedSessionContext.bind(session);
        return (org.hibernate.Session) session;
    }

    /**
     * Start a new Transaction in the given session
     *
     * @param session The session to create the transaction in
     */
    protected void startNewTransaction(Session session) {
        session.beginTransaction();
    }

    /**
     * Shortcut method that creates a new session and begins a transaction in it
     *
     * @return A new session with a transaction started
     */
    protected org.hibernate.Session createNewSessionAndTransaction() {
        Session session = createNewSession();
        startNewTransaction(session);
        return session;
    }

    /**
     * Commit the transaction within the given session. This method unbinds the
     * session from the session context (ManagedSessionContext), flushes the
     * session, commmits the session and then closes the session
     *
     * @param session The session with the transaction to commit
     */
    protected void commitTransaction(Session session) {
        ManagedSessionContext.unbind(HibernateUtil.getSessionFactory());
        session.flush();
        session.getTransaction().commit();
        session.close();
    }

    /**
     * rollback the transaction within the given session. This method unbinds
     * the session from the session context (ManagedSessionContext), flushes the
     * session, commmits the session and then closes the session
     *
     * @param session The session with the transaction to commit
     */
    protected void rollbackTransaction(Session session) {
        ManagedSessionContext.unbind(HibernateUtil.getSessionFactory());
        session.flush();
        session.getTransaction().rollback();
        session.close();
    }

    protected void closeSession(Session session) {
        ManagedSessionContext.unbind(HibernateUtil.getSessionFactory());
        session.flush();
        session.close();
    }
}