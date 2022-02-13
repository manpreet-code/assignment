package daoImpl;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import dao.Dao;
import dao.FlightDao;
import dto.FlightStructure;

public class FlightDaoImpl implements FlightDao {

	@Autowired
	private Dao dao;

	/**
	 * Adds a new Flight
	 * @param FlightStucture
	 */
	public void addFlight(FlightStructure flight) {
		dao.begin();
		dao.getSession().save(flight);
		dao.commit();
		dao.close();
	}

	public List<FlightStructure> getFlights(String arrivalLocation, String departLocation, LocalDate flightDate,
			String flightClass) {
		dao.begin();

		CriteriaBuilder criteriaBuilder = dao.getSession().getCriteriaBuilder();
		CriteriaQuery<FlightStructure> criteriaQuery = criteriaBuilder.createQuery(FlightStructure.class);
		Root<FlightStructure> root = criteriaQuery.from(FlightStructure.class);

		Predicate[] predicates = new Predicate[4];
		predicates[0] = criteriaBuilder.equal(root.get("departLocation"), departLocation);
		predicates[1] = criteriaBuilder.equal(root.get("arrivalLocation"), arrivalLocation);
		Path<LocalDate> flightDatePath = root.get("flightDate");
		predicates[2] = criteriaBuilder.greaterThanOrEqualTo(flightDatePath, flightDate);
		predicates[3] = criteriaBuilder.like(root.<String>get("flightClass"), "%" + flightClass + "%");

		criteriaQuery.select(root).where(predicates);

		Query<FlightStructure> query = dao.getSession().createQuery(criteriaQuery);
		List<FlightStructure> searchResult = query.getResultList();

		dao.commit();
		dao.close();

		return searchResult;
	}

	public List<String> getArrivalLocations() {
		List<String> arrivalLocations;

		dao.begin();
		CriteriaBuilder criteriaBuilder = dao.getSession().getCriteriaBuilder();
		CriteriaQuery<String> criteriaQuery = criteriaBuilder.createQuery(String.class);
		Root<FlightStructure> root = criteriaQuery.from(FlightStructure.class);
		criteriaQuery.multiselect(root.get("arrivalLocation")).distinct(true);
		arrivalLocations = dao.getSession().createQuery(criteriaQuery).getResultList();
		return arrivalLocations;
	}

	public List<String> getDepartureLocations() {
		List<String> departLocations;
		dao.begin();
		CriteriaBuilder criteriaBuilder = dao.getSession().getCriteriaBuilder();
		CriteriaQuery<String> criteriaQuery = criteriaBuilder.createQuery(String.class);
		Root<FlightStructure> root = criteriaQuery.from(FlightStructure.class);
		criteriaQuery.multiselect(root.get("departLocation")).distinct(true);
		departLocations = dao.getSession().createQuery(criteriaQuery).getResultList();
		return departLocations;
	}

}