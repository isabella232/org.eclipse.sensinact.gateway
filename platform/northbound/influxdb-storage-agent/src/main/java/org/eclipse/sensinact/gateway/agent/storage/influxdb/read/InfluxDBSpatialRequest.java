/*
 * Copyright (c) 2021 Kentyou.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Kentyou - initial API and implementation
 */
package org.eclipse.sensinact.gateway.agent.storage.influxdb.read;

import java.util.Map;

import org.eclipse.sensinact.gateway.historic.storage.reader.api.HistoricSpatialRequest;
import org.eclipse.sensinact.gateway.historic.storage.reader.api.SpatialDTO;
import org.eclipse.sensinact.gateway.tools.connector.influxdb.InfluxDbConnector;


public class InfluxDBSpatialRequest extends AbstractInfluxDBValueRequest<SpatialDTO> implements HistoricSpatialRequest{

	protected String region;
	
	public InfluxDBSpatialRequest(InfluxDbConnector influxDbConnector) {
		super(influxDbConnector);
	}

	@Override
	public Map<String, SpatialDTO> execute() {
		return null;
	}

	@Override
	public void setRegion(String region) {
		this.region = region;
	}
}
