package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T14Koutei;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 工程削除
 *
 * @author emarfkrow
 */
public class T14KouteiDeleteAction extends BaseAction {

    /** 工程削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        // 主キーが不足していたらエラー
        Object kouteiId = postJson.get("kouteiId");
        if (kouteiId == null) {
            kouteiId = postJson.get("T14Koutei.kouteiId");
        }
        if (kouteiId == null) {
            throw new OptLockError("error.cant.delete", "工程");
        }

        T14Koutei e = FormValidator.toBean(T14Koutei.class.getName(), postJson);
        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "工程");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}
