package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.M04Saiki;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 再帰削除
 *
 * @author emarfkrow
 */
public class M04SaikiDeleteAction extends BaseAction {

    /** 再帰削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        // 主キーが不足していたらエラー
        Object saikiId = postJson.get("saikiId");
        if (saikiId == null) {
            saikiId = postJson.get("M04Saiki.saikiId");
        }
        if (saikiId == null) {
            throw new OptLockError("error.cant.delete", "再帰");
        }

        M04Saiki e = FormValidator.toBean(M04Saiki.class.getName(), postJson);
        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "再帰");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}
