/*
* Copyright (c) 2020 Kentyou.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
*    Kentyou - initial API and implementation
 */
package org.eclipse.sensinact.gateway.core.method;

import org.eclipse.sensinact.gateway.common.bundle.Mediator;
import org.eclipse.sensinact.gateway.common.execution.Executable;
import org.eclipse.sensinact.gateway.common.primitive.InvalidValueException;
import org.eclipse.sensinact.gateway.common.primitive.JSONable;
import org.eclipse.sensinact.gateway.common.primitive.Primitive;
import org.eclipse.sensinact.gateway.common.primitive.PrimitiveDescription;
import org.eclipse.sensinact.gateway.core.ResourceImpl;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A extended {@link Parameter} whose value is build dynamically using a
 * {@link DynamicParameterValue}
 * 
 * @author <a href="mailto:christophe.munilla@cea.fr">Christophe Munilla</a>
 */
public class DynamicParameter extends Parameter {
	private static final Logger LOG=LoggerFactory.getLogger(DynamicParameter.class);

	/**
	 * Constructor
	 * 
	 * @param name
	 *            this parameter's name
	 * @param type
	 *            this parameter's type
	 * @throws InvalidValueException
	 */
	public DynamicParameter(Mediator mediator, String name, Class<?> type, DynamicParameterValue value)
			throws InvalidValueException {
		super(mediator, name, type);
		super.fixed = true;
		super.fixedValue = value;
	}

	/**
	 * @InheritedDoc
	 *
	 * @see Parameter#reset()
	 */
	@Override
	public void reset() {
		if (LOG.isDebugEnabled()) {
			LOG.debug("reset not implemented for DynamicParameter");
		}
	}

	/**
	 * @inheritDoc
	 *
	 * @see Primitive#getValue()
	 */
	@Override
	public Object getValue() {
		return ((DynamicParameterValue) super.fixedValue).getValue();
	}

	/**
	 * @inheritDoc
	 * 
	 * @see JSONable#getJSON()
	 */
	@Override
	public String getJSON() {
		JSONObject description = super.getJSONObject();
		description.put(PrimitiveDescription.VALUE_KEY, ((DynamicParameterValue) super.fixedValue).getJSON());
		return description.toString();
	}

	/**
	 * Defines the {@link Executable} value extractor of the associated
	 * {@link ResourceImpl} to be used by the registered
	 * {@link DynamicParameterValue}
	 * 
	 * @param resourceValueExtractor
	 *            the {@link Executable} value extractor to set to the
	 *            {@link DynamicParameterValue}
	 */
	protected void setResourceValueExtractor(Executable<Void, Object> extractor) {
		if (super.fixedValue != null) {
			((DynamicParameterValue) super.fixedValue).setResourceValueExtractor(extractor);
		}
	}

	/**
	 * @inheritDoc
	 * 
	 * @see java.lang.Object#clone()
	 */
	public Object clone() {
		try {
			return new DynamicParameter(super.mediator, super.name, super.type,
					(DynamicParameterValue) super.fixedValue);

		} catch (InvalidValueException e) {
			return null;
		}
	}
}
