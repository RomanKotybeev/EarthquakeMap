package earthquakes;


import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import processing.core.PApplet;


/** Implements a common marker for cities and earthquakes on an earthquake map
 * 
 * 
 * @author Kotyubeev Roman
 *
 */
public abstract class CommonMarker extends SimplePointMarker {

	// Records whether this marker has been clicked (most recently)
	protected boolean clicked = false;
	
	public CommonMarker(Location location) {
		super(location);
	}
	
	public CommonMarker(Location location, java.util.HashMap<java.lang.String,java.lang.Object> properties) {
		super(location, properties);
	}
	
	// Getter method for clicked field
	public boolean getClicked() {
		return clicked;
	}
	
	// Setter method for clicked field
	public void setClicked(boolean state) {
		clicked = state;
	}
	
	// Common piece of drawing method for markers; 
	public void draw(PApplet pg, float x, float y) {
		// For starter code just drawMaker(...)
		if (!hidden) {
			drawMarker(pg, x, y);
			if (selected) {
				showTitle(pg, x, y);  // You will implement this in the subclasses
			}
		}
	}
	public abstract void drawMarker(PApplet pg, float x, float y);
	public abstract void showTitle(PApplet pg, float x, float y);
}