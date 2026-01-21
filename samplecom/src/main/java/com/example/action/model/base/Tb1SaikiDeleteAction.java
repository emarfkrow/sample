package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb1Saiki;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 再帰削除
 *
 * @author emarfkrow
 */
public class Tb1SaikiDeleteAction extends BaseAction {

    /** 再帰削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        // 主キーが不足していたらエラー
        Object saikiId = postJson.get("saikiId");
        if (saikiId == null) {
            saikiId = postJson.get("Tb1Saiki.saikiId");
        }
        if (saikiId == null) {
            throw new OptLockError("error.cant.delete", "再帰");
        }

        Tb1Saiki e = FormValidator.toBean(Tb1Saiki.class.getName(), postJson);
        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "再帰");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}
