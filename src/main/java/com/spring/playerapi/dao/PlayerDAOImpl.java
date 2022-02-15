package com.spring.playerapi.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.playerapi.model.Player;

@Repository
public class PlayerDAOImpl implements PlayerDAO {

	private SessionFactory sessionFactory;
	
	@Autowired
	public PlayerDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Player> getPlayers() {
		Session session = sessionFactory.getCurrentSession();
		Query<Player> query = session.createQuery("from Player order by name asc", Player.class);
		
		return query.getResultList();
	}

	@Override
	public void addPlayer(Player player) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(player);
		
	}

	@Override
	public Player getPlayer(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Player.class, id);
	}

	@Override
	public void deletePlayer(int id) {
		Session session = sessionFactory.getCurrentSession();
		Player player = getPlayer(id);
		//Query query = session.createQuery("delete from players where id = :myid");
		//query.setInteger("myid", id);
		//query.executeUpdate();
		session.delete(player);
	}
	
	
	
	
}
