package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T09Koho1;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 候補１削除
 *
 * @author emarfkrow
 */
public class T09Koho1DeleteAction extends BaseAction {

    /** 候補１削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        // 主キーが不足していたらエラー
        Object koho1Id = postJson.get("koho1Id");
        if (koho1Id == null) {
            koho1Id = postJson.get("T09Koho1.koho1Id");
        }
        if (koho1Id == null) {
            throw new OptLockError("error.cant.delete", "候補１");
        }

        T09Koho1 e = FormValidator.toBean(T09Koho1.class.getName(), postJson);
        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "候補１");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}
