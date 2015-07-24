package br.com.convert.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.convert.bean.FileBean;
import br.com.convert.interfaces.InterfaceFile;
import br.com.convert.util.FormatData;
import br.com.peopleway.util.DBUtilMySQL;


public class FileDao implements InterfaceFile{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Connection conn = null;
	private PreparedStatement prp = null;
	private ResultSet rs = null;
	private List<FileBean> list = null;
	FileBean bean = null;
	
	
	@Override
	public List<FileBean> listFiles() {
		list = new ArrayList<FileBean>();
		try {
			conn = DBUtilMySQL.getPooledConnection();
			prp = conn.prepareStatement("SELECT * FROM files ORDER BY date DESC;");
			rs = prp.executeQuery();
			
			while(rs.next()){
				bean = new FileBean();
				bean.setName(rs.getString("name"));
				bean.setDate(FormatData.dateFormatedToString("dd/MM/yyyy HH:mm:ss", FormatData.stringToDate("yyyy-MM-dd HH:mm:ss", rs.getString("date"))));
				list.add(bean);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(prp != null){
					prp.close();
				}
				if(rs != null){
					rs.close();
				} 
				if (conn != null) {
					conn.close();
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	@Override
	public void saveFileName(String fileName) {
		SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dataFormat = formatador.format(new Date());
		
		try {
			conn = DBUtilMySQL.getPooledConnection();
			prp = conn.prepareStatement("INSERT INTO files VALUES (?,?,?);");
			prp.setString(1, null);
			prp.setString(2, dataFormat);
			prp.setString(3, fileName);
			
			prp.execute();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (prp != null) {
					prp.close();
				}
				if (conn != null) {
					conn.close();
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	/*@SuppressWarnings("unchecked")
	public List<Files> listFiles(){
			EntityManager manager = new JPAUtil().getEntityManager();
			
			List<Files> list = new ArrayList<Files>();

			Query query = manager.createQuery("select u from Files u order by u.date desc");

			list = query.getResultList();

			return list;
	}

	public void saveFileName(Files file) {
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		
		manager.persist(file);
		
		manager.getTransaction().commit();
		manager.close();
	}*/
}
