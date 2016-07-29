/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gym.dao.util;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;

/**
 *
 * @author JOSE
 * @param <T>
 */
public class GenericoDAO<T> extends ManagedSession {

    protected org.hibernate.Session session;

    protected void getSessionTransaction() {
        session = createNewSessionAndTransaction();
    }

    protected void getSession() {
        session = createNewSession();
    }
    
    /**
     * obtener cantidad de los registros por un filtro y sql adicional (éste sql
     * adicional es para usar a listas como e.g: 'idCuenta in (1,2,3)')
     *
     * @param filters
     * @param sqlAdicional
     * @return
     * @throws Exception
     */
    public Long buscarCantidadRegistros(Map<String, Object> filters, final String sqlAdicional) throws Exception {
        getSession();
        Criteria cr = session.createCriteria(cargarClase());
        if (null != filters) {
            for (Iterator<SimpleExpression> it = this.getCriteriaFiltro(filters).iterator(); it.hasNext();) {
                SimpleExpression expression = it.next();
                cr.add(expression);
            }
        }
        if (null != sqlAdicional && !sqlAdicional.isEmpty()) {
            cr.add(Restrictions.sqlRestriction(sqlAdicional));
        }
        Integer cantidad = (Integer) cr.setProjection(Projections.rowCount()).uniqueResult();
        return cantidad.longValue();
    }
    
    
    
    
    
    /**
     * obtiene los criteria a partir del filtro para la consulta
     *
     * @param filters
     * @return
     */
    protected List<SimpleExpression> getCriteriaFiltro(final Map<String, Object> filters) {
        List<SimpleExpression> restriccionses = new ArrayList<SimpleExpression>();
        if (null != filters) {
            for (Map.Entry<String, Object> filtro : filters.entrySet()) {
                String col = filtro.getKey();
                Object value = filtro.getValue();
                if (value instanceof Integer || value instanceof Boolean) {
                    restriccionses.add(Restrictions.eq(col, value));
                } else {
                    restriccionses.add(Restrictions.like(col, value.toString(), MatchMode.ANYWHERE).ignoreCase());
                }

            }
        }
        return restriccionses;
    }

    /**
     * Metodo generico para hacer persistir una entidad
     *
     * @param entidad entidad a tratar
     * @throws Exception Maneja las excepciones lanzadas por la transaccion
     */
    public void crear(T entidad) throws Exception {
        try {
            getSessionTransaction();
            session.persist(entidad);
            commitTransaction(session);
        } catch (HibernateException e) {
            rollbackTransaction(session);
            lanzarSQLException(e);
        }
    }

    /**
     * Metodo generico para realizar actualizaciones sobre una entidad.
     *
     * @param entidad entidad a tratar
     * @throws Exception Maneja las excepciones lanzadas por la transaccion
     */
    public void editar(T entidad) throws Exception {
        try {
            getSessionTransaction();
            session.merge(entidad);
            commitTransaction(session);
        } catch (HibernateException e) {
            rollbackTransaction(session);
            lanzarSQLException(e);
        }
    }

    /**
     * Metodo generico para rsessionover una entidad de la base de datos
     *
     * @param entidad entidad a tratar
     * @throws Exception Maneja las excepciones lanzadas por la transaccion
     */
    public void eliminar(T entidad) throws Exception {
        try {
            getSessionTransaction();
            session.delete(session.merge(entidad));
            commitTransaction(session);
        } catch (HibernateException e) {
            rollbackTransaction(session);
            lanzarSQLException(e);
        }
    }

    /**
     * Metodo generico para buscar por el id de la entidad
     *
     * @param entidad entidad a tratar
     * @throws Exception Maneja las excepciones lanzadas por la transaccion
     */
    public T buscarPorId(Serializable id) throws Exception {
        try {
            getSession();
            T entidad = (T) session.get(cargarClase(), id);
            if (entidad != null) {
                session.refresh(entidad);
            }
            return entidad;
        } catch (HibernateException e) {
            lanzarSQLException(e);
            throw e;
        } finally {
            session.close();
        }
    }

    /**
     * Metodo generico para buscar todos los datos de una entidad en la base de
     * datos
     *
     * @throws Exception Maneja las excepciones lanzadas por la transaccion
     */
    public List<T> buscarTodos() throws Exception {
        try {
            getSession();
            Criteria cr = session.createCriteria(cargarClase());
            List<T> results = cr.list();
//            if(results != null){
//            for (T object : results) {
//                session.refresh(object);
//            }
//            }
            return results;
        } catch (HibernateException e) {
            lanzarSQLException(e);
            throw e;
        } finally {
            session.close();
        }

    }

    /**
     * Metodo generico para buscar todos los datos de una entidad en la base de
     * datos por rango
     *
     * @param min desde el primer resultado
     * @param max hasta el ultimo resultado
     * @throws Exception Maneja las excepciones lanzadas por la transaccion
     */
    public List<T> buscarTodos(Integer min, Integer max) throws Exception {
        try {
            getSession();
            Criteria cr = session.createCriteria(cargarClase());
            cr.setFirstResult(min);
            cr.setMaxResults(max);
            List<T> result = cr.list();
            return result;
        } catch (HibernateException e) {
            lanzarSQLException(e);
            throw e;
        } finally {
            session.close();
        }

    }

    /**
     * Carga las clase con la que actualmente se trabaja, Se hace referencia a
     * esta clase que es una entidad con el generico T
     *
     * @return La clase sobre la cual se esta trabajando
     */
    private Class<T> cargarClase() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    protected void lanzarSQLException(HibernateException ge) throws Exception {
        if (ge.getCause() != null && ge.getCause() instanceof SQLException) {
            SQLException se = (SQLException) ge.getCause();
            throw new Exception(se.getNextException().getMessage());
        } else {
            throw new Exception(ge.getMessage());
        }
    }

    protected String getFiltro(Map<String, String> filtros) {
        String filtro = "";
        String wildCard = "%";
        if (filtros != null) {
            for (Map.Entry<String, String> filter : filtros.entrySet()) {
                if (!filter.getValue().equals("")) {
                    if (!filtro.isEmpty()) {
                        filtro += " AND ";
                    }
                    filtro += " UPPER(CAST(" + filter.getKey() + " AS string)) LIKE UPPER('" + wildCard + filter.getValue() + wildCard + "')";
                }
            }
        }
        return filtro;
    }
    protected String getFiltro5_0(Map<String, Object> filtros) {
        String filtro = "";
        String wildCard = "%";
        if (filtros != null) {
            for (Map.Entry<String, Object> filter : filtros.entrySet()) {
                if (!filter.getValue().equals("")) {
                    if (!filtro.isEmpty()) {
                        filtro += " AND ";
                    }
                    filtro += " UPPER(CAST(" + filter.getKey() + " AS string)) LIKE UPPER('" + wildCard + filter.getValue() + wildCard + "')";
                }
            }
        }
        return filtro;
    }

    protected String getOrden(String sortField, String sortOrder) {
        String orden = "";
        if (sortField != null && sortOrder != null) {
            orden = " ORDER BY " + sortField;
            if (sortOrder == "ASCENDING") {
                orden += " ASC";
            } else if (sortOrder == "DESCENDING") {
                orden += " DESC";
            }
        }
        return orden;
    }
}
