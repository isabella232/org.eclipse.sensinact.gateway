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
package org.eclipse.sensinact.gateway.core.security.entity;

import org.eclipse.sensinact.gateway.core.security.entity.annotation.Column;
import org.eclipse.sensinact.gateway.core.security.entity.annotation.ForeignKey;
import org.eclipse.sensinact.gateway.core.security.entity.annotation.NotNull;
import org.eclipse.sensinact.gateway.core.security.entity.annotation.PrimaryKey;
import org.eclipse.sensinact.gateway.core.security.entity.annotation.Table;
import org.json.JSONObject;

/**
 * ObjectProfileAccess DAO Entity
 * 
 * @author <a href="mailto:christophe.munilla@cea.fr">Christophe Munilla</a>
 */
@Table(value = "OBJECT_PROFILE_ACCESS")
@PrimaryKey(value = { "MID", "OPID", "OAID" })
public class ObjectProfileAccessEntity extends ImmutableSnaEntity {
	@NotNull
	@Column(value = "MID")
	@ForeignKey(refer = "MID", table = "METHOD")
	private long methodEntity;

	@NotNull
	@Column(value = "OPID")
	@ForeignKey(refer = "OPID", table = "OBJECT_PROFILE")
	private long objectProfileEntity;

	@NotNull
	@Column(value = "OAID")
	@ForeignKey(refer = "OAID", table = "OBJECT_ACCESS")
	private long objectAccessEntity;

	/**
	 * Constructor
	 * 
	 */
	public ObjectProfileAccessEntity() {
		super();
	}

	/**
	 * Constructor
	 * 
	 * @param row
	 */
	protected ObjectProfileAccessEntity(JSONObject row) {
		super(row);
	}

	/**
	 * Constructor
	 * 
	 * @param methodEntity
	 * @param objectProfileEntity
	 * @param objectAccessEntity
	 */
	protected ObjectProfileAccessEntity(long methodEntity, long objectProfileEntity,
			long objectAccessEntity) {
		super();
		this.setMethodEntity(methodEntity);
		this.setObjectProfileEntity(objectProfileEntity);
		this.setObjectAccessEntity(objectAccessEntity);
	}

	/**
	 * @return the objectAccess
	 */
	public long getObjectAccessEntity() {
		return objectAccessEntity;
	}

	/**
	 * @param objectAccess
	 *            the objectAccess to set
	 */
	public void setObjectAccessEntity(long objectAccessEntity) {
		this.objectAccessEntity = objectAccessEntity;
	}

	/**
	 * @return the objectProfile
	 */
	public long getObjectProfileEntity() {
		return objectProfileEntity;
	}

	/**
	 * @param objectProfile
	 *            the objectProfile to set
	 */
	public void setObjectProfileEntity(long objectProfileEntity) {
		this.objectProfileEntity = objectProfileEntity;
	}

	/**
	 * @return the method
	 */
	public long getMethodEntity() {
		return methodEntity;
	}

	/**
	 * @param method
	 *            the method to set
	 */
	public void setMethodEntity(long methodEntity) {
		this.methodEntity = methodEntity;
	}
}
