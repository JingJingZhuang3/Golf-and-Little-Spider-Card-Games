package solitaire;

import java.util.Observable;

public interface Observer {
	public void update();

	void update(Observable arg0, Object arg1);
}

