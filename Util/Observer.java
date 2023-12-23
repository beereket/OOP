package Util;

public interface Observer {
	void update();
	void update(String journalName, String paperTitle);
}
