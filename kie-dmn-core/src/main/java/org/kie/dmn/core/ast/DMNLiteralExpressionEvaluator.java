/*
 * Copyright 2016 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.kie.dmn.core.ast;

import org.kie.dmn.core.api.event.InternalDMNRuntimeEventManager;
import org.kie.dmn.core.impl.DMNResultImpl;
import org.kie.dmn.feel.FEEL;
import org.kie.dmn.feel.lang.CompiledExpression;

/**
 * An evaluator for DMN Literal Expressions
 */
public class DMNLiteralExpressionEvaluator
        implements DMNExpressionEvaluator {
    private CompiledExpression expression;

    public DMNLiteralExpressionEvaluator(CompiledExpression expression) {
        this.expression = expression;
    }

    @Override
    public EvaluatorResult evaluate(InternalDMNRuntimeEventManager eventManager, DMNResultImpl result) {
        Object val = FEEL.newInstance().evaluate( expression, result.getContext().getAll() );
        return new EvaluatorResult( val, ResultType.SUCCESS );
    }
}
