package earthquakes;


import de.fhpotsdam.unfolding.data.PointFeature;
import processing.core.PApplet;
import processing.core.PGraphics;

/** Implements a visual marker for ocean earthquakes on an earthquake map
 * 
 * @author Kotyubeev Roman
 *
 */
public class OceanQuakeMarker extends EarthquakeMarker {
	
	public OceanQuakeMarker(PointFeature quake) {
		super(quake);
		
		// setting field in earthquake marker
		isOnLand = false;
	}
	

	/** Draw the earthquake as a square */
	@Override
	public void drawEarthquake(PApplet pg, float x, float y) {
		pg.rect(x-radius, y-radius, 2*radius, 2*radius);
		
		pg.noFill();
		pg.ellipse(x, y, (float)threatCircle(), (float)threatCircle());
	}

}
