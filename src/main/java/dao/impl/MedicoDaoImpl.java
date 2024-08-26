package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import config.DatabaseAccess;
import dao.MedicoDao;
import models.Medico;

public class MedicoDaoImpl implements MedicoDao{

	@Override
	public List<Medico> listarMedicos() {
		Connection cn = null;
		List<Medico> medicos = null;
		try {
			cn = DatabaseAccess.getConnection();
			String sql = "SELECT id_medico, tipo_documento, numero_documento, imagen_url, nombres, apellido_paterno, apellido_materno, sexo, especialidad FROM medico where estado_auditoria='1'";
			
			PreparedStatement pstm = cn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			
			medicos = new ArrayList();
			while(rs.next()) {
				medicos.add(resultSetToObject(rs));
			}
			
			rs.close();
			pstm.close();
			
		} catch (Exception e) {
			System.out.println(e);
			medicos=null;	
		} finally {
			try {
				if(cn != null) {
					cn.close();
				}
			} catch (Exception e2) {
				System.out.println(e2);
			}
		}
			return medicos;
	}

	@Override
	public Medico obtenerMedico(Integer id) {
		Connection cn = null;
		Medico medico = null;
		try {
			cn = DatabaseAccess.getConnection();
			String sql = "SELECT id_medico, tipo_documento, numero_documento, imagen_url, nombres, apellido_paterno, apellido_materno, sexo, especialidad FROM medico where estado_auditoria='1'AND id_medico = ?";
			
			PreparedStatement pstm = cn.prepareStatement(sql);
			pstm.setInt(1, id);
			
			ResultSet rs = pstm.executeQuery();
			
			if(rs.next()) {
				medico = resultSetToObject(rs);
			}
			
			rs.close();
			pstm.close();
			
		} catch(Exception e){
			System.out.println(e);
			medico = null;
		} finally {
			try {
				if(cn != null) {
					cn.close();
				}
			} catch (Exception e2) {
				System.out.println(e2);
			}
		}

		return medico;
	}
		
	private Medico resultSetToObject(ResultSet rs) throws Exception {
		Medico medico = new Medico();
		medico.setIdMedico(rs.getInt("id_medico"));
		medico.setTipoDocumento(rs.getString("tipo_documento"));
		medico.setNumeroDocumento(rs.getString("numero_documento"));
		medico.setImagenUrl(rs.getString("imagen_url"));
		medico.setNombres(rs.getString("nombres"));
		medico.setApellidoPaterno(rs.getString("apellido_paterno"));
		medico.setApellidoMaterno(rs.getString("apellido_materno"));
		medico.setSexo(rs.getString("sexo"));
		medico.setEspecialidad(rs.getString("especialidad"));
		return medico;
	}
	
	

}
