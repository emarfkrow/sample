package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T00Unique;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * ユニークキー削除
 *
 * @author emarfkrow
 */
public class T00UniqueDeleteAction extends BaseAction {

    /** ユニークキー削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        // 主キーが不足していたらエラー
        Object dMei = postJson.get("dMei");
        if (dMei == null) {
            dMei = postJson.get("T00Unique.dMei");
        }
        if (dMei == null) {
            throw new OptLockError("error.cant.delete", "ユニークキー");
        }
        Object eMei = postJson.get("eMei");
        if (eMei == null) {
            eMei = postJson.get("T00Unique.eMei");
        }
        if (eMei == null) {
            throw new OptLockError("error.cant.delete", "ユニークキー");
        }

        T00Unique e = FormValidator.toBean(T00Unique.class.getName(), postJson);
        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "ユニークキー");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}
