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

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.sensinact.gateway.historic.storage.reader.api.HistoricSpatioTemporalRequest;
import org.eclipse.sensinact.gateway.historic.storage.reader.api.SpatioTemporalDTO;
import org.eclipse.sensinact.gateway.tools.connector.influxdb.InfluxDbConnector;


public class InfluxDBSpatioTemporalRequest extends AbstractInfluxDBTemporalRequest<List<SpatioTemporalDTO>> implements HistoricSpatioTemporalRequest{

	protected String region;
	
	public InfluxDBSpatioTemporalRequest(InfluxDbConnector influxDbConnector) {
		super(influxDbConnector);
	}

	@Override
	public Map<String, List<SpatioTemporalDTO>> execute() {
		return Collections.emptyMap();
	}

	@Override
	public void setRegion(String region) {
		this.region = region;
	}
}
