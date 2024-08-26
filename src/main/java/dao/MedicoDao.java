package dao;
import java.util.List;

import models.Medico;

public interface MedicoDao {
		public List<Medico> listarMedicos();
		public Medico obtenerMedico(Integer id);
}
