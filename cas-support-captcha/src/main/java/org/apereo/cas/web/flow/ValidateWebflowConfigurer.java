/*
 * 版权所有.(c)2008-2017. 卡尔科技工作室
 */

package org.apereo.cas.web.flow;

import org.apereo.cas.web.flow.AbstractCasWebflowConfigurer;
import org.apereo.cas.web.flow.CasWebflowConstants;
import org.springframework.webflow.engine.ActionState;
import org.springframework.webflow.engine.Flow;
import org.springframework.webflow.execution.Action;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Carl
 * @date 2017/10/30
 */
public class ValidateWebflowConfigurer extends AbstractCasWebflowConfigurer {
    /**
     * 校验码动作
     */
    public static final String VALIDATE_CAPTCHA_ACTION = "validateCaptchaAction";

    public ValidateWebflowConfigurer() {
        super();
    }

    @Override
    protected void doInitialize() throws Exception {
        createLoginValidateValidateFlow();
    }

    /**
     * 登录校验流程
     */
    private void createLoginValidateValidateFlow() {
        final Flow flow = getLoginFlow();
        if (flow != null) {
            final ActionState state = (ActionState) flow.getState(CasWebflowConstants.TRANSITION_ID_REAL_SUBMIT);
            final List<Action> currentActions = new ArrayList<>();
            state.getActionList().forEach(currentActions::add);
            currentActions.forEach(a -> state.getActionList().remove(a));

            state.getActionList().add(createEvaluateAction("validateLoginCaptchaAction"));
            currentActions.forEach(a -> state.getActionList().add(a));

            state.getTransitionSet().add(createTransition("captchaError", CasWebflowConstants.STATE_ID_INIT_LOGIN_FORM));
        }
    }
}