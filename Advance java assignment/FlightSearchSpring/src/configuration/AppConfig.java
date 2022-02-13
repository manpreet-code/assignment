package configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import dao.Dao;
import dao.FlightDao;
import dao.FlightFileDao;
import dao.LoginDao;
import daoImpl.DaoImpl;
import daoImpl.FlightDaoImpl;
import daoImpl.FlightFilesDaoImpl;
import daoImpl.LoginDaoImpl;
import services.AirportCodeLoaderService;
import services.FareComparatorService;
import services.FlightLoaderService;
import services.FlightSearchService;
import services.LoginService;
import services.OutputPreferenceService;


@Configuration
@EnableScheduling
public class AppConfig {

	@Bean
	public Dao getDao() {
		return new DaoImpl();
	}

	@Bean
	public LoginDao getUserDao() {
		return new LoginDaoImpl();
	}

	@Bean
	public FlightDao getFlightDao() {
		return new FlightDaoImpl();
	}

	@Bean
	public FlightFileDao getFlightFileDao() {
		return new FlightFilesDaoImpl();
	}

	@Bean
	public FlightLoaderService getFlightLoader() {
		return new FlightLoaderService();
	}

	@Bean
	public FlightSearchService getFlightSearch() {
		return new FlightSearchService();
	}

	@Bean
	public AirportCodeLoaderService getAirportCodeLoader() {
		return new AirportCodeLoaderService();
	}

	@Bean
	public OutputPreferenceService getOutputPreferance() {
		return new OutputPreferenceService();
	}

	@Bean
	public FareComparatorService getFlightComparator() {
		return new FareComparatorService();
	}

	@Bean
	public LoginService getUserService() {
		return new LoginService();
	}

}