package com.etel.gaaaperbos;

import java.util.List;

import com.coopdb.data.Tbgaaperbos;
import com.wavemaker.runtime.javaservice.JavaServiceSuperClass;
import com.wavemaker.runtime.service.annotations.ExposeToClient;

/**
 * This is a client-facing service class.  All
 * public methods will be exposed to the client.  Their return
 * values and parameters will be passed to the client or taken
 * from the client, respectively.  This will be a singleton
 * instance, shared between all requests. 
 * 
 * To log, call the superclass method log(LOG_LEVEL, String) or log(LOG_LEVEL, String, Exception).
 * LOG_LEVEL is one of FATAL, ERROR, WARN, INFO and DEBUG to modify your log level.
 * For info on these levels, look for tomcat/log4j documentation
 */
@ExposeToClient
public class GAAPerBOSFacade extends JavaServiceSuperClass {
    /* Pass in one of FATAL, ERROR, WARN,  INFO and DEBUG to modify your log level;
     *  recommend changing this to FATAL or ERROR before deploying.  For info on these levels, look for tomcat/log4j documentation
     */
    public GAAPerBOSFacade() {
       super(INFO);
    }
    GAAPerBOSService srvc = new GAAPerBOSServiceImpl(); 
    
    public String saveGAA(Tbgaaperbos gaaperbos) {
       return srvc.saveGAA(gaaperbos);
    }
	public List<Tbgaaperbos> listGAAPerBOS(String boscode){
		return srvc.listGAAPerBOS(boscode);
	}
	public String deleteGAA(int id){
		return srvc.deleteGAA(id);
	}
}
