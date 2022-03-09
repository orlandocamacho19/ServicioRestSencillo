package DAO;

import Excepciones.DAOException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import objetos_negocio.Equipo;

public class EquipoDAO extends BaseDAO<Equipo> {

    @Override
    public ArrayList<Equipo> consultar() throws DAOException {
        EntityManager entityManager = this.generarConexion();
        entityManager.getTransaction().begin();

        Query consult = entityManager.createQuery("SELECT v FROM Client v");
        List<Equipo> equipos = consult.getResultList();

        entityManager.getTransaction().commit();
        return new ArrayList<>(equipos);
    }

    @Override
    public void instertar(Equipo entidad) throws DAOException {
        EntityManager entityManager = this.generarConexion();
        entityManager.getTransaction().begin();
        entityManager.persist(entidad);
        entityManager.getTransaction().commit();
    }

    @Override
    public void actualizar(Equipo entidad) throws DAOException {
        EntityManager entityManager = this.generarConexion();
        entityManager.getTransaction().begin();
        Equipo equipoGuardado = entityManager.find(Equipo.class, entidad.getId());
        if (equipoGuardado != null) {
            equipoGuardado.setNombre(entidad.getNombre());
            entityManager.persist(equipoGuardado);
        } else {
            throw new DAOException("El equipo " + entidad.getId() + " no existe");
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public void eliminar(Long id) throws DAOException {
        EntityManager entityManager = this.generarConexion();
        entityManager.getTransaction().begin();
        Equipo equipo = entityManager.find(Equipo.class, id);
        if (equipo != null) {
            entityManager.remove(equipo);
        } else {
            throw new DAOException("El equipo " + id + " no existe");
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public Equipo consultarPorId(Long id) throws DAOException {
        EntityManager entityManager = this.generarConexion();
        Equipo equipo = entityManager.find(Equipo.class, id);
        if (equipo != null) {
            return equipo;
        } else {
            throw new DAOException("El equipo " + id + " no existe");
        }
    }
}
