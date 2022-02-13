package com.nagarro.services;

import org.hibernate.Session;

import com.nagarro.Models.Image;
import com.nagarro.utils.HibernateUtilities;
import org.hibernate.query.Query;


 public class ImageManagementService {
	/**
	 * Get an image from database
	 * 
	 */
	public Image getImage(String imageid) {
		Image image = null;
		try (Session session = HibernateUtilities.getSessionInstance()) {
			String queryString = "from Image where imageId = :imageId";
			Query<?> query = session.createQuery(queryString).setParameter("imageId", Long.parseLong(imageid));
			image = (Image) query.uniqueResult();
		} catch (Exception e) {
//			System.out.println(e.getMessage());
		}
		return image;
	}

	/**
	 * Add an image to database corresponding to a given user
	 * 
	 */
	public void addImage(Image image) {
		try (Session session = HibernateUtilities.getSessionInstance()) {
			session.save(image);
			session.getTransaction().commit();
		} catch (Exception e) {
//			e.printStackTrace();
		}
	}

	/**
	 * method to edit an image
	 *
	 */
	public void editImage(Image newImage) {
		try (Session session = HibernateUtilities.getSessionInstance()) {
			session.update(newImage);
			session.getTransaction().commit();
		} catch (Exception e) {
//			e.printStackTrace();
		}
	}

	/**
	 * method to delete an image present in database using HQL
	 * 
	 */
	public void deleteImage(String imageid) {
		try (Session session = HibernateUtilities.getSessionInstance()) {
			String query = "delete from Image where imageId= :imageId";
			session.createQuery(query).setParameter("imageId", Long.parseLong(imageid)).executeUpdate();
			session.getTransaction().commit();
		} catch (Exception e) {
//			e.printStackTrace();
		}
	}
}
