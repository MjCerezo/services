package com.etel.history;

import java.util.List;

import com.coopdb.data.Tbhistory;
import com.wavemaker.runtime.javaservice.JavaServiceSuperClass;
import com.wavemaker.runtime.service.annotations.ExposeToClient;

/**
 * This is a client-facing service class. All public methods will be exposed to
 * the client. Their return values and parameters will be passed to the client
 * or taken from the client, respectively. This will be a singleton instance,
 * shared between all requests.
 * 
 * To log, call the superclass method log(LOG_LEVEL, String) or log(LOG_LEVEL,
 * String, Exception). LOG_LEVEL is one of FATAL, ERROR, WARN, INFO and DEBUG to
 * modify your log level. For info on these levels, look for tomcat/log4j
 * documentation
 */
@ExposeToClient
public class HistoryFacade extends JavaServiceSuperClass {
	/*
	 * Pass in one of FATAL, ERROR, WARN, INFO and DEBUG to modify your log level;
	 * recommend changing this to FATAL or ERROR before deploying. For info on these
	 * levels, look for tomcat/log4j documentation
	 */
	public HistoryFacade() {
//       super(INFO);
	}

	public List<Tbhistory> listHistory(String cifno) {
		HistoryService service = new HistoryServiceImpl();
		return service.listHistory(cifno);
	}

	public String addHistory(String cifno, String description, String remarks) {
		HistoryService service = new HistoryServiceImpl();
		return service.addHistory(cifno, description, remarks);
	}

	// MAR 10-13-2020
	public String saveHistory(String appno, Integer eventid, String eventdescription) {
		HistoryService service = new HistoryServiceImpl();
		return service.saveHistory(appno, eventid, eventdescription);
	}

}
