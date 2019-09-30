package earthquakes;

import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.geo.Location;
import processing.core.PApplet;
import processing.core.PGraphics;

/** Implements a visual marker for cities on an earthquake map
 * 
 * @author Kotyubeev Roman
 *
 */
public class CityMarker extends CommonMarker {
	
	public static int TRI_SIZE = 5;  // The size of the triangle marker
	
	public CityMarker(Location location) {
		super(location);
	}
	
	
	public CityMarker(Feature city) {
		super(((PointFeature)city).getLocation(), city.getProperties());
		// Cities have properties: "name" (city name), "country" (country name)
		// and "population" (population, in millions)
	}

	
	/**
	 * Implementation of method to draw marker on the map.
	 */
	@Override
	public void drawMarker(PApplet pg, float x, float y) {
		// Save previous drawing style
		pg.pushStyle();
		
		// drawing triangle for each city
		pg.fill(150, 30, 30);
		pg.triangle(x, y-TRI_SIZE, x-TRI_SIZE, y+TRI_SIZE, x+TRI_SIZE, y+TRI_SIZE);
		
		// Restore previous drawing style
		pg.popStyle();
	}
	
	
	/** Show the title of the city if this marker is selected */
	@Override
	public void showTitle(PApplet pg, float x, float y)
	{
		pg.textSize(10);
		pg.fill(0);
		pg.text(getCity() + ", " + getCountry() , x+5, y);
		pg.text(getPopulation() + "k" , x+5, y+10);
	}
	
	
	
	/* Local getters for some city properties.  
	 */
	public String getCity()
	{
		return getStringProperty("name");
	}
	
	public String getCountry()
	{
		return getStringProperty("country");
	}
	
	public float getPopulation()
	{
		return Float.parseFloat(getStringProperty("population"));
	}

}
