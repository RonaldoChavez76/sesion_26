package mx.utng.s26.sesion26.model.dao;
import java.util.List;
import mx.utng.s26.sesion26.model.entity.Subjet;

public interface ISubjetDao {
    List<Subjet> list();
  void save(Subjet subjet);
  Subjet getById(Long id);
  void delete(Long id);
}
