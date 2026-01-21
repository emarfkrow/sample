package com.example.action;

import com.example.entity.MhrUser;

import jp.co.golorp.emarf.action.base.PassmailActionBase;
import jp.co.golorp.emarf.form.LoginForm;

/**
 * パスワードリセットメール送信
 * @author toshiyuki
 *
 */
public class PassmailAction extends PassmailActionBase {

    @Override
    protected final LoginForm getLoginForm(final String userId) {

        MhrUser mhrUser = MhrUser.get(userId);

        LoginForm loginForm = new LoginForm();
        loginForm.setEmail(mhrUser.getEMail());
        loginForm.setAuthnMei(mhrUser.getUserSei() + mhrUser.getUserMei());

        return loginForm;
    }

}
