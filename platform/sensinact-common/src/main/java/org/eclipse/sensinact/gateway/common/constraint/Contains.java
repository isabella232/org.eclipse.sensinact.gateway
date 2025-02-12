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
package org.eclipse.sensinact.gateway.common.constraint;

import org.eclipse.sensinact.gateway.util.CastUtils;

import java.util.logging.Level;

/**
 * Constraint on the presence of an object in a set of data
 *
 * @param <T> the handled data set type
 * @author <a href="mailto:christophe.munilla@cea.fr">Christophe Munilla</a>
 */
public class Contains<T> extends ConstraintOnCollection<T> {
    public static final String OPERATOR = "in";

    /**
     * Constructor
     *
     * @param operator
     * @param operandClass
     * @param operand
     * @throws InvalidConstraintDefinitionException
     */
    public Contains(Class<T> operandClass, Object operand, boolean complement) throws InvalidConstraintDefinitionException {
        super(OPERATOR, operandClass, operand, complement);
    }

    /**
     * @inheritDoc
     * @see Constraint#complies(java.lang.Object)
     */
    @Override
    public boolean complies(Object value) {
        boolean complies = false;
        T castedValue = null;
        try {
            castedValue = CastUtils.cast(super.operandClass, value);
        } catch (ClassCastException e) {
            return complies;
        }
        int index = 0;
        for (; index < super.operand.length; index++) {
            if (castedValue.equals(super.operand[index])) {
                complies = true;
                break;
            }
        }
        return (complies ^ isComplement());
    }

    /**
     * @inheritDoc
     * @see Constraint#getComplement()
     */
    @Override
    public Constraint getComplement() {
        Contains<T> complement = null;
        try {
            complement = new Contains<T>(super.operandClass, super.operand, !super.complement);
        } catch (InvalidConstraintDefinitionException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
        }
        return complement;
    }
}
