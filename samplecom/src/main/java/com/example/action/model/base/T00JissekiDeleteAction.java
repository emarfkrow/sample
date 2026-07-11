package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T00Jisseki;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 実績削除
 *
 * @author emarfkrow
 */
public class T00JissekiDeleteAction extends BaseAction {

    /** 実績削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        // 主キーが不足していたらエラー
        Object kouteiId = postJson.get("kouteiId");
        if (kouteiId == null) {
            kouteiId = postJson.get("T00Jisseki.kouteiId");
        }
        if (kouteiId == null) {
            throw new OptLockError("error.cant.delete", "実績");
        }
        Object jissekiBn = postJson.get("jissekiBn");
        if (jissekiBn == null) {
            jissekiBn = postJson.get("T00Jisseki.jissekiBn");
        }
        if (jissekiBn == null) {
            throw new OptLockError("error.cant.delete", "実績");
        }

        T00Jisseki e = FormValidator.toBean(T00Jisseki.class.getName(), postJson);
        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "実績");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}
