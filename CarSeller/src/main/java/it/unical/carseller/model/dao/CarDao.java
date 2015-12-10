package it.unical.carseller.model.dao;

import java.util.List;

import it.unical.carseller.model.Color;
import it.unical.carseller.model.CarModel;

public interface CarDao {
	void create(CarModel m);
	CarModel getCarModel(String name);
	List<CarModel> getAllCarModels();
	void update(CarModel m);
	void delete(CarModel m);
	
	void create(Color m);
	Color getColor(String name);
	List<Color> getAllColors();
	void update(Color m);
	void delete(Color m);
}
