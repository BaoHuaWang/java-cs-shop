package com.Jie.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Jie.Entity.Entity;

public class GoodsDao {

	/*
	 * ��Ʒ��ѯ����
	 */
	public Goods FindById(String goodsid) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Goods rg = null;
		String sql = "";
		sql = "select * from goods where goodsid=?";
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, goodsid);
			rs = ps.executeQuery();//���ܽ����
			if (rs.next()) {
				rg = new Goods();
				//��ȡ�����������ԣ���ʼ�����¶�����
				rg.setGoodsId(goodsid);
				rg.setGoodsName(rs.getString("goodsname"));
				rg.setGoodsPrice(rs.getString("goodsprice"));
				rg.setGoodsCount(rs.getString("goodscount"));
				rg.setResult(true);
			}else{
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(rs, ps, conn);
		}
		return rg;
	}
	
	
	
	/*
	 * �����Ʒ����
	 */
	public boolean add(Entity g) {
		GoodsDao gd =new GoodsDao();
		if(gd.FindById(g.getGoodsid())==null){
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			String sql = "";
			sql = "insert into goods (goodsid,goodsname,goodsprice,goodscount)value(?,?,?,?)";
			try {
				conn = DBUtils.getConnection();
				ps = conn.prepareStatement(sql);
				ps.setString(1, g.getGoodsid());
				ps.setString(2, g.getGoodsname());
				ps.setString(3, g.getGoodsprice());
				ps.setString(4, g.getGoodscount());
				int num = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBUtils.close(rs, ps, conn);
			}
		}else{
			System.out.println("��Ʒ�Ѵ��ڣ�");
			return false;
		}
		
		return true;
	}
	
	
	
	/*
	 * test
	 */
	public static void main(String[] args) {
		GoodsDao gd =new GoodsDao();
		Goods g =new Goods();
		g.setGoodsId("10086");
		g=gd.FindById(g.getGoodsId());
		System.out.println(g.getGoodsId()+g.getGoodsName()+g.getGoodsPrice()+g.getGoodsCount());
		double d=0;
		System.out.println(Double.valueOf(g.getGoodsPrice()));
	}


	/*
	 * ɾ����Ʒ����
	 */
	public boolean del(Entity g) {
		GoodsDao gd =new GoodsDao();
		if(gd.FindById(g.getGoodsid())!=null){
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			String sql = "";
			sql = "delete from goods where goodsid = ?";
			try {
				conn = DBUtils.getConnection();
				ps = conn.prepareStatement(sql);
				ps.setString(1, g.getGoodsid());
				int num = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBUtils.close(rs, ps, conn);
			}
		}else{
			System.out.println("��Ʒ�����ڣ�");
			return false;
		}
		
		return true;
	}


	/*
	 * �޸���Ʒ����
	 */
	public boolean update(Entity g) {
		GoodsDao gd =new GoodsDao();
		if(gd.FindById(g.getGoodsid())!=null){
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			String sql = "";
			sql = "update goods set goodsname=?,goodsprice=?,goodscount=? where goodsid=?";
			try {
				conn = DBUtils.getConnection();
				ps = conn.prepareStatement(sql);
				ps.setString(4, g.getGoodsid());
				ps.setString(1, g.getGoodsname());
				ps.setString(2, g.getGoodsprice());
				ps.setString(3, g.getGoodscount());
				int num = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBUtils.close(rs, ps, conn);
			}
		}else{
			System.out.println("�޸�ʧ�ܣ�");
			return false;
		}
		
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
}
