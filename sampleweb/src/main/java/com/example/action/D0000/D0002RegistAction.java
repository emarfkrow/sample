package com.example.action.D0000;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T02Ko;
import com.example.entity.T02Mago;
import com.example.entity.T02Oya;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.AppError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 詳細画面登録アクション
 * @author toshiyuki
 *
 */
public class D0002RegistAction extends BaseAction {

    /**
     *
     */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String id, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        T02Oya oya = FormValidator.toBean(T02Oya.class.getName(), postJson);
        if (oya.isEmpty()) {
            throw new AppError("error.cant.regist");
        }

        T02Ko ko = FormValidator.toBean(T02Ko.class.getName(), postJson);

        if (!ko.isEmpty()) {
            oya.addT02Kos(ko);

            T02Mago mago = FormValidator.toBean(T02Mago.class.getName(), postJson);
            if (!mago.isEmpty()) {
                ko.addT02Magos(mago);
            }
        }

        if (oya.isNew()) {
            if (oya.insert(now, id) != 1) {
                throw new AppError("error.cant.insert");
            }
        } else {
            if (oya.update(now, id) != 1) {
                throw new AppError("error.cant.update");
            }
        }

        map.put("INFO", Messages.get("info.update"));
        return map;
    }

}
