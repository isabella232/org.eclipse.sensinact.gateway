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
package org.eclipse.sensinact.gateway.historic.storage.reader.api;

import java.time.ZonedDateTime;
import java.util.List;

/**
 *
 */
public interface HistoricTemporalRequest extends HistoricRequest<List<TemporalDTO>> {

	void setHistoricStartTime(ZonedDateTime fromTime);

	void setHistoricEndTime(ZonedDateTime toTime);
	
	void setFunction(String function);	

	void setTemporalWindow(long period);
	
}
