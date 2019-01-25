package com.sbz.core.patterns.builder.director;

/**
 * <p>Title: FIX Engine</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Somebiz Networks</p>
 * @author Pedro Garcia
 * @version 1.0
 */

import com.sbz.core.patterns.builder.builder.TibcoAdapterParametersBuilder;
import com.sbz.core.patterns.builder.builder.TibcoAdapterBuilder;
import com.sbz.core.patterns.builder.builder.MAppPropertiesBuilder;
import com.sbz.parsing.XMLManager;
import com.sbz.core.tibco.Adapter;

public class AdapterBuilderDirector {

	private XMLManager xmlManager = null;
	private TibcoAdapterParametersBuilder parametersBuilder = null;
	private TibcoAdapterBuilder adapterBuilder = null;
	private MAppPropertiesBuilder mappBuilder = null;
        private String configFile = null;

  public AdapterBuilderDirector(String configFile) {

  	xmlManager = new XMLManager();
  	parametersBuilder = new TibcoAdapterParametersBuilder();
  	adapterBuilder = new TibcoAdapterBuilder();
  	mappBuilder = new MAppPropertiesBuilder();
        this.configFile = configFile;
  }

  public Adapter createAdapter(String adapter){
        parametersBuilder.setConfigFile(configFile);
  	parametersBuilder.buildAdapterParameters(adapter, xmlManager);
  	mappBuilder.buildMappProperties(parametersBuilder.getAdapterParameters().getMAppParameters());
  	adapterBuilder.buildAdapter(adapter,mappBuilder.getMappProperties(), parametersBuilder.getAdapterParameters(), parametersBuilder.getClassParameters());

  	return adapterBuilder.getAdapterBuilt();
  }
}