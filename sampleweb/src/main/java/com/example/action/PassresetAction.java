package com.example.action;

import java.time.LocalDateTime;

import com.example.entity.MhrUser;

import jp.co.golorp.emarf.action.base.PassresetActionBase;
import jp.co.golorp.emarf.exception.AppError;
import jp.co.golorp.emarf.lang.StringUtil;

/**
 * パスワードリセット
 * @author toshiyuki
 *
 */
public class PassresetAction extends PassresetActionBase {

    @Override
    protected final boolean resetPassword(final LocalDateTime now, final String id, final String passwd,
            final String userId) {

        MhrUser mUser = MhrUser.get(userId);

        if (mUser != null) {

            mUser.setPassword(StringUtil.hash(passwd));

            if (mUser.update(now, id) != 1) {
                throw new AppError("error.cant.update");
            }

            return true;
        }

        return false;
    }

}
