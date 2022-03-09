package DAO;

import Excepciones.DAOException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import objetos_negocio.Equipo;

public abstract class BaseDAO<T> {

    protected EntityManager generarConexion() throws DAOException {
        try {
            EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("crudJpaPU");
            EntityManager entityManager = managerFactory.createEntityManager();
            return entityManager;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    public abstract ArrayList<T> consultar() throws DAOException;

    public abstract void instertar(T entidad) throws DAOException;

    public abstract void actualizar(T entidad) throws DAOException;

    public abstract void eliminar(Long id) throws DAOException;

    public abstract T consultarPorId(Long id) throws DAOException;
    
}
